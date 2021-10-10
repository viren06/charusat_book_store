package com.example.charusatbookstore

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class cspitdepartment : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cspitdepartment)
        var college= intent.getStringExtra("college")

        val ib=findViewById<Button>(R.id.idbuttoncspitce)
        ib.setOnClickListener {
            val Intent=Intent(this,sem::class.java)
            Intent.putExtra("department","CE")
            Intent.putExtra("college",college)
            startActivity(Intent)
        }
        val ib1=findViewById<Button>(R.id.button21)
        ib1.setOnClickListener {
            val Intent=Intent(this,sem::class.java)
            Intent.putExtra("department","CSE")
            Intent.putExtra("college",college)
            startActivity(Intent)
        }
        val ib2=findViewById<Button>(R.id.button22)
        ib2.setOnClickListener {
            val Intent=Intent(this,sem::class.java)
            Intent.putExtra("department","IT")
            Intent.putExtra("college",college)
            startActivity(Intent)
        }
        val ib3=findViewById<Button>(R.id.button23)
        ib3.setOnClickListener {
            val Intent=Intent(this,sem::class.java)
            Intent.putExtra("department","EC")
            Intent.putExtra("college",college)
            startActivity(Intent)
        }
        val ib4=findViewById<Button>(R.id.button24)
        ib4.setOnClickListener {
            val Intent = Intent(this, sem::class.java)
            Intent.putExtra("department","MECH")
            Intent.putExtra("college",college)
            startActivity(Intent)
        }
        val ib5=findViewById<Button>(R.id.button25)
        ib5.setOnClickListener {
            val Intent=Intent(this,sem::class.java)
            Intent.putExtra("department","EE")
            Intent.putExtra("college",college)
            startActivity(Intent)
        }
        val ib6=findViewById<Button>(R.id.button26)
        ib6.setOnClickListener {
            val Intent = Intent(this, sem::class.java)
            Intent.putExtra("department","CIVIL")
            Intent.putExtra("college",college)
            startActivity(Intent)
        }
    }
}