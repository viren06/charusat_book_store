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
            val Intent = Intent(this,cspitsem1subject::class.java)
            startActivity(Intent)
        }
    }

}