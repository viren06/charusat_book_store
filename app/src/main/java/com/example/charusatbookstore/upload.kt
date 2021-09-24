package com.example.charusatbookstore

import android.app.Activity
import android.app.ProgressDialog
import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import androidx.lifecycle.ViewModelProviders
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.storage.FirebaseStorage
import com.theartofdev.edmodo.cropper.CropImage
import java.util.*
import android.widget.Toast.makeText as makeText1



class upload : AppCompatActivity() {
    var imaguri:Uri?=null
    var username:String?=null
    var profilepic:String?=null
    lateinit var  college1:Spinner
    lateinit var department :Spinner
    lateinit var semester : Spinner
    lateinit var subjecttext :EditText
    lateinit var pricetext:EditText
    lateinit var descriptiontext :EditText
    lateinit var takephoto:TextView
    lateinit var bookphoto:ImageView

    var firebaseuid=FirebaseAuth.getInstance().currentUser!!.uid

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_upload)

        college1 = findViewById<Spinner>(R.id.spinner)
        department = findViewById<Spinner>(R.id.spinner2)
        semester = findViewById<Spinner>(R.id.spinner3)
        subjecttext = findViewById<EditText>(R.id.subjectetid)
        pricetext = findViewById<EditText>(R.id.priceetid)
        descriptiontext = findViewById<EditText>(R.id.descriptionetid)
        takephoto = findViewById<TextView>(R.id.upload_bookPhoto)
        bookphoto = findViewById<ImageView>(R.id.book_photo)

        val viewModel = ViewModelProviders.of(this).get(upload_bookViewModel::class.java)
        viewModel.getdata(firebaseuid)?.observe(this, androidx.lifecycle.Observer {
            username = it.username
            profilepic = it.img
        })
        //val takephoto = findViewById<TextView>(R.id.upload_bookPhoto)
        takephoto.setOnClickListener {
            CropImage.activity().setAspectRatio(1, 1).start(this)
        }
        val uploadbtn = findViewById<Button>(R.id.uploadbuttonid)
        uploadbtn.setOnClickListener {
            var progressDialog = ProgressDialog(this)
            progressDialog.setTitle("uploading Book Details")
            progressDialog.setMessage("Your book will upload in few seconds")
            progressDialog.show()

            var bookStorage = FirebaseStorage.getInstance().reference.child("book")
            if (imaguri != null) {
                val fileref = bookStorage!!.child(UUID.randomUUID().toString())
                val uploadTask = fileref.putFile(imaguri!!)
                if (uploadTask != null) {
                    uploadTask.addOnCompleteListener {
                        if (it.isSuccessful) {
                            var downloadurl = fileref
                            var firebase = FirebaseDatabase.getInstance().getReference("Book")
                            var key = firebase.push().key
                            viewModel.savedata(
                                firebaseuid,
                                college1.selectedItem.toString(),
                                department.selectedItem.toString(),
                                semester.selectedItem.toString(),
                                subjecttext.text.toString(),
                                pricetext.text.toString(),
                                descriptiontext.text.toString(),
                                downloadurl.toString(),
                                key.toString(),
                                username!!
                            )
                            progressDialog.dismiss()
                            startActivity(Intent(this, college::class.java))
                        }
                    }
                }
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode==CropImage.CROP_IMAGE_ACTIVITY_REQUEST_CODE && resultCode==Activity.RESULT_OK && data!=null){
            var result=CropImage.getActivityResult(data)
            imaguri=result.uri
            bookphoto.setImageURI(imaguri)
        }
    }
}



