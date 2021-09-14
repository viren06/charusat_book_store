package com.example.charusatbookstore

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import android.widget.Toast.makeText as makeText1

class upload : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_upload)
        //val college = findViewById<Spinner>(R.id.spinner)
        val uploadbtn = findViewById<Button>(R.id.button20)
        //val tvshow = findViewById<TextView>(R.id.textView8)
        uploadbtn.setOnClickListener {
            val Intent = Intent(this,showbook::class.java)
            startActivity(Intent)
            //tvshow.getInputExtras()

        }
    }
}

//private fun TextView.getInputExtras() {
//}
