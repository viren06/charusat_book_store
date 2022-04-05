package com.example.charusatbookstore

import android.content.Intent
import android.graphics.Color
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.bumptech.glide.Glide
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import com.razorpay.Checkout
import com.razorpay.PaymentResultListener
import org.json.JSONObject

class book_details : AppCompatActivity() , PaymentResultListener {
    val database = FirebaseDatabase.getInstance()
    private  var mauth: FirebaseAuth?=null
    private var bid:String?=null
    private var uid:String?=null
    private var imageuri: Uri?=null
    private var firebaseStorage: StorageReference?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book_details)

        var bokname=findViewById<TextView>(R.id.textView14)
        var subname=findViewById<TextView>(R.id.textView15)
        var Price=findViewById<TextView>(R.id.textView17)
        var Uploadby=findViewById<TextView>(R.id.textView19)
        var email=findViewById<TextView>(R.id.textView21)
        var number=findViewById<TextView>(R.id.textView23)
        var bookimage=findViewById<ImageView>(R.id.imageView)
        var btnmail=findViewById<Button>(R.id.button28)
        var btnsms=findViewById<Button>(R.id.btnsms)
        var paynow=findViewById<Button>(R.id.btnpay)
        var bid=intent.getStringExtra("bid")
        var bookname=intent.getStringExtra("bname")
        var price=intent.getStringExtra("price")
        var sub=intent.getStringExtra("sub")
        var flag=intent.getStringExtra("flag")
        var uid=intent.getStringExtra("userid")

        paynow.setOnClickListener {
            savePayments(Price.text.toString().trim().toInt())
        }

        Checkout.preload(this@book_details)

        mauth = FirebaseAuth.getInstance()
        var user=mauth!!.currentUser
        if(flag=="1"){
            btnmail.visibility= View.GONE
            btnsms.visibility= View.GONE
        }

        val myref=database.getReference("Book")
        myref.child(bid!!).addListenerForSingleValueEvent(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                val value=snapshot.getValue(bookModel::class.java)
                if(value!=null){
                    bokname.setText(bookname)
                    subname.setText(sub)
                    Price.setText(price)

                    if(value.img!=""){
                        val storage = FirebaseStorage.getInstance()
                        val storageReference=storage.getReferenceFromUrl(value.img!!)

                        storageReference.downloadUrl.addOnSuccessListener {
                            val imgurl = it.toString()
                            Glide.with(this@book_details).load(imgurl).into(bookimage).view
                        }
                    }
                }
            }
            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }
        })



        btnmail.setOnClickListener(View.OnClickListener { view ->
            // Do some work here
            val to = "${email.text}"
            val subject = "I want To Buy ${bookname.toString()}"
            val body = "I want To Buy ${bookname.toString()} Book of Subject ${sub.toString()} at Price ${price.toString()}₹"
            val mailTo = "mailto:" + to +
                    "?&subject=" + Uri.encode(subject) +
                    "&body=" + Uri.encode(body)
            val emailIntent = Intent(Intent.ACTION_VIEW)
            emailIntent.data = Uri.parse(mailTo)
            startActivity(emailIntent)
        })

        btnsms.setOnClickListener(View.OnClickListener { v: View? ->
            val uri = Uri.parse("smsto:+91${number.text}")
            val intent = Intent(Intent.ACTION_SENDTO, uri)
            intent.putExtra("sms_body", "I want To Buy ${bookname.toString()} Book of Subject ${sub.toString()} at Price ${price.toString()}₹")
            startActivity(intent)
        })

        val userREf=database.getReference("user")
        userREf.child(uid!!).addListenerForSingleValueEvent(object :ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val uvalue=snapshot.getValue(userModel::class.java)
                if(uvalue!=null){
                    Uploadby.setText(uvalue.username)
                    email.setText(uvalue.email)

                    number.setText(uvalue.mobile_number)

                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })

    }
    private fun savePayments(amount: Int) {
        val checkout = Checkout()
        checkout.setKeyID("rzp_test_yDSK1wCF7eSErr")
        try {
            val options = JSONObject()
            options.put("name", "Razorpay Demo")
            options.put("description", "If You Like these Tutorials. Buy me a Coffee")
            //options.put("image","")
            options.put("theme.color", "#3399cc")
            options.put("currency", "INR")
            options.put("amount", amount * 100)

            val retryObj = JSONObject()
            retryObj.put("enabled", true)
            retryObj.put("max_count", 4)
            options.put("retry", retryObj)
            checkout.open(this@book_details, options)

        } catch (e: Exception) {
            Toast.makeText(this@book_details, "Error in Payment : " + e.message, Toast.LENGTH_LONG)
                .show()
            e.printStackTrace()
        }
    }

    override fun onPaymentSuccess(p0: String?) {
        Toast.makeText(this,"Payment Success: "+ p0,Toast.LENGTH_LONG).show()

    }
    override fun onPaymentError(p0: Int, p1: String?) {
        Toast.makeText(this,"Payment Failed: "+ p1,Toast.LENGTH_LONG).show()
    }
}