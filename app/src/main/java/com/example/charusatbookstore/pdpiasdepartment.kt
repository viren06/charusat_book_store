package com.example.charusatbookstore

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class pdpiasdepartment : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pdpiasdepartment)
        val ib=findViewById<Button>(R.id.button15)
        ib.setOnClickListener {
            val Intent= Intent(this,sem::class.java)
            startActivity(Intent)
        }
        val ib1=findViewById<Button>(R.id.button16)
        ib1.setOnClickListener {
            val Intent= Intent(this,sem::class.java)
            startActivity(Intent)
        }
        val ib2=findViewById<Button>(R.id.button17)
        ib2.setOnClickListener {
            val Intent= Intent(this,sem::class.java)
            startActivity(Intent)
        }
        val ib3=findViewById<Button>(R.id.button18)
        ib3.setOnClickListener {
            val Intent= Intent(this,sem::class.java)
            startActivity(Intent)
        }
        val ib4=findViewById<Button>(R.id.button19)
        ib4.setOnClickListener {
            val Intent= Intent(this,sem::class.java)
            startActivity(Intent)
        }

    }
}