package com.example.charusatbookstore

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class sem : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sem)

        val iv1=findViewById<ImageView>(R.id.sem1)
        iv1.setOnClickListener {
            val Intent = Intent(this,showbook::class.java)
            startActivity(Intent)
        }
        val iv2=findViewById<ImageView>(R.id.sem2)
        iv2.setOnClickListener {
            val Intent = Intent(this,Depstar_CE_Sem2_Subject::class.java)
            startActivity(Intent)
        }
        val iv3=findViewById<ImageView>(R.id.sem3)
        iv3.setOnClickListener {
            val Intent = Intent(this,Depstar_CE_Sem3_Subject::class.java)
            startActivity(Intent)
        }
        val iv4=findViewById<ImageView>(R.id.sem4)
        iv4.setOnClickListener {
            val Intent = Intent(this,Depstar_CE_Sem4_Subject::class.java)
            startActivity(Intent)
        }
    }

}