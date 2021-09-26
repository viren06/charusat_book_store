package com.example.charusatbookstore

import android.app.Activity
import android.content.Intent
import android.graphics.PointF
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.bumptech.glide.Glide
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import com.theartofdev.edmodo.cropper.CropImage

class Edit_profile : AppCompatActivity() {
    lateinit var edit_image:ImageView
    lateinit var edit_name:EditText
    lateinit var edit_number:EditText
    lateinit var edit_username:EditText
   lateinit var edit_email:EditText
    lateinit var btndone:ImageView
    lateinit var progressBar:ProgressBar


    private var checked=""
    private  lateinit var firebaseUser: FirebaseUser
    private var myUrl=""
    private var imageuri:Uri?=null
    private var firebaseStorage:StorageReference?=null

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == CropImage.CROP_IMAGE_ACTIVITY_REQUEST_CODE && resultCode == Activity.RESULT_OK && data != null) {
            var result = CropImage.getActivityResult(data)
            imageuri = result.uri
            edit_image.setImageURI(imageuri)
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_profile)
         edit_image=findViewById<ImageView>(R.id.edit_image)
         edit_name=findViewById<EditText>(R.id.edit_name)
         edit_number=findViewById<EditText>(R.id.edit_number)
         edit_username=findViewById<EditText>(R.id.edit_username)
         edit_email=findViewById<EditText>(R.id.edit_email)
        btndone=findViewById<ImageView>(R.id.btndone)
        progressBar=findViewById<ProgressBar>(R.id.progressBar)
         var edit_change_profile=findViewById<TextView>(R.id.edit_change_profile)
        var btnclose=findViewById<ImageView>(R.id.btnclose)


        val viewModel=ViewModelProviders.of(this).get(Edit_ProfileViewModel::class.java)
        val user=FirebaseAuth.getInstance().currentUser!!.uid
        var profileimgurl:String?=null
        firebaseStorage=FirebaseStorage.getInstance().reference.child("Profile_pic")
        viewModel.getdata(user)?.observe(this, Observer {
            edit_number.setText(it.mobile_number)
            edit_username.setText(it.username)
            edit_name.setText(it.name)
            if(it.img!="" && it.img!="null"){
                val storage=FirebaseStorage.getInstance()
                val storageReference = storage.getReferenceFromUrl(it.img!!)
                profileimgurl=it.img.toString()
                storageReference.downloadUrl.addOnSuccessListener {
                    Glide.with(this).load(it.toString()).into(edit_image).view
                }
            }
            edit_email.setText(it.email)
        })
        btndone.setOnClickListener {
            progressBar.visibility=View.VISIBLE
            if(imageuri!=null){
                val fileref=firebaseStorage!!.child(user+".jpg")
                val uploadTask=fileref.putFile(imageuri!!)
                if(uploadTask!=null){
                    uploadTask.
                        addOnCompleteListener { taskSnapshot->
                            val downloadUrl=fileref
                            progressBar.visibility=View.GONE
                            viewModel.savedata(
                                user,
                                edit_name.text.toString(),
                                edit_number.text.toString(),
                                edit_username.text.toString(),
                                edit_email.text.toString(),
                                downloadUrl.toString()
                            )
                            startActivity(Intent(this,college::class.java))
                            finish()
                    }
                        .addOnFailureListener{
                            progressBar.visibility=View.GONE

                        }
                }
                else{
                    progressBar.visibility=View.GONE

                }
            }
            else{
                viewModel.savedataonly(
                    user,
                    edit_name.text.toString(),
                    edit_number.text.toString(),
                    edit_username.text.toString(),
                    edit_email.text.toString(),
                    profileimgurl.toString()
                )
                progressBar.visibility=View.GONE
                startActivity(Intent(this,college::class.java))
                finish()
            }


        }
        edit_change_profile.setOnClickListener {
//            Toast.makeText(this,"hello",Toast.LENGTH_SHORT).show()
            CropImage.activity().setAspectRatio(1,1).start(this)
        }
        btnclose.setOnClickListener {
            startActivity(Intent(this,college::class.java))
            finish()
        }
    }
}