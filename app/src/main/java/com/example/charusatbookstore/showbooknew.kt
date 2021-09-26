package com.example.charusatbookstore

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast

class showbooknew : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_showbooknew)

        val lv = findViewById<ListView>(R.id.listview)
        val names = arrayOf("C", "C++", "python")

        val arrayAdapter: ArrayAdapter<String> = ArrayAdapter(
            this, android.R.layout.simple_list_item_1,names
        )

        lv.adapter = arrayAdapter

        lv.setOnItemClickListener { adapterView, view, i, l ->
            Toast.makeText(this,"Item Selected"+names[i],Toast.LENGTH_SHORT).show()
        }
    }
}