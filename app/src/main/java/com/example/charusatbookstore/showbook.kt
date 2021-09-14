package com.example.charusatbookstore

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

class showbook : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_showbook)

        Toast.makeText(applicationContext,"Upload successfully !!!",Toast.LENGTH_LONG).show()
    }
}