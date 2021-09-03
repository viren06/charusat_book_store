package com.example.charusatbookstore

import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class login : AppCompatActivity() {
    override fun onStart() {
        super.onStart()
        var user = FirebaseAuth.getInstance().currentUser
        if (user != null) {
            updateUi(user)
        }
    }



        override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        val button3=findViewById<Button>(R.id.button3)
        button3.setOnClickListener{
            startActivity(Intent(this,sign_up::class.java))
        }

        val button2=findViewById<Button>(R.id.button2)
        button2.setOnClickListener{
            var email = findViewById<EditText>(R.id.login_email)
            var passwoed = findViewById<EditText>(R.id.login_password)
            var progressDialog= ProgressDialog(this)
            progressDialog.setTitle("It will take some time")
            progressDialog.setMessage("hello")
            progressDialog.show()
            var mauth= FirebaseAuth.getInstance()

            mauth.signInWithEmailAndPassword(email.text.toString(),passwoed.text.toString()).addOnCompleteListener(this) {
                if(it.isSuccessful){
                    var user=mauth.currentUser
                    updateUi(user)
                    progressDialog.dismiss()
                }
                else
                    progressDialog.dismiss()
            }
                .addOnCanceledListener {
                    progressDialog.dismiss()
                }
        }

        }
    
    private fun updateUi(user: FirebaseUser?){
        if(user!!.isEmailVerified){
            startActivity(Intent(this,college::class.java))
            finish()
        }
        else{
            user.sendEmailVerification()
            Toast.makeText(this,"Verify email first",Toast.LENGTH_LONG).show()
        }
    }

}