package com.example.charusatbookstore

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class cspitdepartment : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cspitdepartment)

        val ib=findViewById<Button>(R.id.idbuttoncspitce)
        ib.setOnClickListener {
            val Intent=Intent(this,sem::class.java)
            startActivity(Intent)
        }
    }
}