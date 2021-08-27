package com.example.charusatbookstore

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class depstardepartment : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_depstardepartment)
        val ib=findViewById<Button>(R.id.button6)
        ib.setOnClickListener {
            val Intent= Intent(this,sem::class.java)
            startActivity(Intent)
        }
        val ib1=findViewById<Button>(R.id.button7)
        ib1.setOnClickListener {
            val Intent= Intent(this,sem::class.java)
            startActivity(Intent)
        }
        val ib2=findViewById<Button>(R.id.button8)
        ib2.setOnClickListener {
            val Intent= Intent(this,sem::class.java)
            startActivity(Intent)
        }

    }
}