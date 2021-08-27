package com.example.charusatbookstore

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class cmpicadepartment : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cmpicadepartment)
        val ib=findViewById<Button>(R.id.button11)
        ib.setOnClickListener {
            val Intent= Intent(this,sem::class.java)
            startActivity(Intent)
        }
        val ib1=findViewById<Button>(R.id.button12)
        ib1.setOnClickListener {
            val Intent= Intent(this,sem::class.java)
            startActivity(Intent)
        }
    }
}