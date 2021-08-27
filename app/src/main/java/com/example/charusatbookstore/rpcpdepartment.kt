package com.example.charusatbookstore

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class rpcpdepartment : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rpcpdepartment)
        val ib=findViewById<Button>(R.id.button13)
        ib.setOnClickListener {
            val Intent= Intent(this,sem::class.java)
            startActivity(Intent)
        }
        val ib1=findViewById<Button>(R.id.button14)
        ib1.setOnClickListener {
            val Intent= Intent(this,sem::class.java)
            startActivity(Intent)
        }
    }
}