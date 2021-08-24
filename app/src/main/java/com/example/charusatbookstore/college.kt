package com.example.charusatbookstore

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton

class college : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_college)
        val ib1=findViewById<ImageButton>(R.id.idimageButtondepstar)
        ib1.setOnClickListener{
            val Intent = Intent(this,depstardepartment::class.java)
            startActivity(Intent)
        }
        val ib2=findViewById<ImageButton>(R.id.idimageButtoncspit)
        ib2.setOnClickListener{
            val Intent = Intent(this,cspitdepartment::class.java)
            startActivity(Intent)
        }
        val ib3=findViewById<ImageButton>(R.id.idimageButtoncmpica)
        ib3.setOnClickListener{
            val Intent = Intent(this,cmpicadepartment::class.java)
            startActivity(Intent)
        }
        val ib4=findViewById<ImageButton>(R.id.idimageButtonpdpias)
        ib4.setOnClickListener{
            val Intent = Intent(this,pdpiasdepartment::class.java)
            startActivity(Intent)
        }
        val ib5=findViewById<ImageButton>(R.id.idimageButtonrpcp)
        ib5.setOnClickListener{
            val Intent = Intent(this,rpcpdepartment::class.java)
            startActivity(Intent)
        }
        val ib6=findViewById<ImageButton>(R.id.idimageButtoni2im)
        ib6.setOnClickListener{
            val Intent = Intent(this,i2imdepartment::class.java)
            startActivity(Intent)
        }
    }
}