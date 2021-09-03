package com.example.charusatbookstore

import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.FirebaseDatabase

class sign_up : AppCompatActivity() {
    override fun onStart(){
        super.onStart()
        var user=FirebaseAuth.getInstance().currentUser
        if(user!=null)
            updateUi(user)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        val button5=findViewById<Button>(R.id.button5)
        button5.setOnClickListener{
            startActivity(Intent(this,login::class.java))
            finish()
        }
//sign up
        val button4=findViewById<Button>(R.id.button4)
        button4.setOnClickListener{
            var email=findViewById<EditText>(R.id.signup_email)
            var password=findViewById<EditText>(R.id.signup_password)
            var username=findViewById<EditText>(R.id.signup_userrname)
            var name=findViewById<EditText>(R.id.signup_fullname)
            var mobile_number=findViewById<EditText>(R.id.signup_number)

            var progressDialog=ProgressDialog(this)
            progressDialog.setTitle("It will take some time")
            progressDialog.setMessage("Signing Up")
            progressDialog.show()


            when{
                TextUtils.isEmpty(email.text.toString())->email.error="Required"
                TextUtils.isEmpty(password.text.toString())->Toast.makeText(this,"Enter password",Toast.LENGTH_LONG).show()
                TextUtils.isEmpty(username.text.toString())->Toast.makeText(this,"Enter username",Toast.LENGTH_LONG).show()
                TextUtils.isEmpty(name.text.toString())->Toast.makeText(this,"Enter full name",Toast.LENGTH_LONG).show()
                TextUtils.isEmpty(mobile_number.text.toString())->Toast.makeText(this,"Enter mobile number",Toast.LENGTH_LONG).show()
                else->{
                    var emailStud="[a-zA-Z0-9._-]+@charusat.edu.in".toRegex()
                    if (email.text?.matches(emailStud)!!){
                        Toast.makeText(this,"charusat",Toast.LENGTH_SHORT).show()
                        var mauth=FirebaseAuth.getInstance()
                        mauth.createUserWithEmailAndPassword(email.text.toString(),password.text.toString()).addOnCompleteListener(this) {it->
                            if (it.isSuccessful){
                                var user=mauth.currentUser
                                var hashMap=HashMap<String,Any>()
                                //firebase data entry
                                hashMap["username"]=username.text.toString()
                                hashMap["email"]=email.text.toString()
                                hashMap["uid"]=user!!.uid
                                hashMap["name"]=name.text.toString()
                                hashMap["mobile_number"]=mobile_number.text.toString()

                                var myref=FirebaseDatabase.getInstance().getReference("user")
                                myref.child(user!!.uid.toString()).setValue(hashMap).addOnCompleteListener(this){
                                    Toast.makeText(this,"user created",Toast.LENGTH_SHORT).show()
                                    updateUi(user)
                                    progressDialog.dismiss()
                                }
                            }
                            else{

                        }
                    }
                            .addOnCanceledListener {
                                Toast.makeText(this,"error try after some time",Toast.LENGTH_LONG).show()
                                progressDialog.dismiss()
                            }
                }
                    else{
                        progressDialog.dismiss()
                        email.error="Enter Charusat email id"

                    }
                }
            }
            progressDialog.dismiss()
        }
    }
    private fun updateUi(user: FirebaseUser?) {
        if(user!!.isEmailVerified)
        {
            startActivity(Intent(this,college::class.java))
            finish()
        }
        else{
            user.sendEmailVerification()
            Toast.makeText(this,"Verification mail sent your mail",Toast.LENGTH_LONG).show()
            startActivity(Intent(this,login::class.java))

        }

    }

}



