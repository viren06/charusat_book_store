package com.example.charusatbookstore

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast

class showbook : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_showbook)

        //get data from intent
        var intent = intent
        val subject = intent.getStringExtra("Subject")
        val price = intent.getStringExtra("Price")
        val description = intent.getStringExtra("Description")

        //textview
        val resulttv = findViewById<TextView>(R.id.showdataid)

        //settext
        resulttv.text = "Subject :-"+subject+"\nPrice of Book :-"+price+"\nDescription of Book :-"+description
        Toast.makeText(applicationContext,"Upload successfully !!!",Toast.LENGTH_LONG).show()
    }
}