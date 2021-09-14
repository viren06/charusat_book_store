package com.example.charusatbookstore

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import android.widget.Toast.makeText as makeText1



class upload : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_upload)
        //val college = findViewById<Spinner>(R.id.spinner)
        //val department = findViewById<Spinner>(R.id.spinner2)
        //val semester = findViewById<Spinner>(R.id.spinner3)
        val subjecttext = findViewById<EditText>(R.id.subjectetid)
        val pricetext = findViewById<EditText>(R.id.priceetid)
        val descriptiontext = findViewById<EditText>(R.id.descriptionetid)
        val uploadbtn = findViewById<Button>(R.id.uploadbuttonid)
        uploadbtn.setOnClickListener {

           // var clgvar = college.Spinner.toString()
            //var devar = subjecttext.text.toString()
            //var semvar = subjecttext.text.toString()
            var subvar = subjecttext.text.toString()
            var pvar = pricetext.text.toString()
            var dpvar = descriptiontext.text.toString()
            val intent = Intent(this,showbook::class.java)
            intent.putExtra("Subject",subvar)
            intent.putExtra("Price",pvar)
            intent.putExtra("Description",dpvar)
            startActivity(intent)

        }
    }
}



