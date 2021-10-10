package com.example.charusatbookstore

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class sem : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sem)
        val department=intent.getStringExtra("department")
        val college=intent.getStringExtra("college")
        val iv1=findViewById<ImageView>(R.id.sem1)
        iv1.setOnClickListener {
            val Intent = Intent(this,showbook::class.java)
            Intent.putExtra("sem","SEM 1")
            Intent.putExtra("college",college)
            Intent.putExtra("department",department)
            startActivity(Intent)
        }
        val iv2=findViewById<ImageView>(R.id.sem2)
        iv2.setOnClickListener {
            val Intent = Intent(this,showbook::class.java)
            Intent.putExtra("sem","SEM 2")
            Intent.putExtra("college",college)
            Intent.putExtra("department",department)
            startActivity(Intent)
        }
        val iv3=findViewById<ImageView>(R.id.sem3)
        iv3.setOnClickListener {
            val Intent = Intent(this,showbook::class.java)
            Intent.putExtra("sem","SEM 3")
            Intent.putExtra("college",college)
            Intent.putExtra("department",department)
            startActivity(Intent)
        }
        val iv4=findViewById<ImageView>(R.id.sem4)
        iv4.setOnClickListener {
            val Intent = Intent(this,showbook::class.java)
            Intent.putExtra("sem","SEM 4")
            Intent.putExtra("college",college)
            Intent.putExtra("department",department)
            startActivity(Intent)
        }

        val iv5=findViewById<ImageView>(R.id.sem5)
        iv5.setOnClickListener {
            val Intent = Intent(this,showbook::class.java)
            Intent.putExtra("sem","SEM 5")
            Intent.putExtra("college",college)
            Intent.putExtra("department",department)
            startActivity(Intent)
        }

        val iv6=findViewById<ImageView>(R.id.sem6)
        iv6.setOnClickListener {
            val Intent = Intent(this,showbook::class.java)
            Intent.putExtra("sem","SEM 6")
            Intent.putExtra("college",college)
            Intent.putExtra("department",department)
            startActivity(Intent)
        }

        val iv7=findViewById<ImageView>(R.id.sem7)
        iv7.setOnClickListener {
            val Intent = Intent(this,showbook::class.java)
            Intent.putExtra("sem","SEM 7")
            Intent.putExtra("college",college)
            Intent.putExtra("department",department)
            startActivity(Intent)
        }

        val iv8=findViewById<ImageView>(R.id.sem8)
        iv8.setOnClickListener {
            val Intent = Intent(this,showbook::class.java)
            Intent.putExtra("sem","SEM 8")
            Intent.putExtra("college",college)
            Intent.putExtra("department",department)
            startActivity(Intent)
        }
    }

}