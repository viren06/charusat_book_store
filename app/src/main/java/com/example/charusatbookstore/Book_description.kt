package com.example.charusatbookstore

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class Book_description : AppCompatActivity() {

    val database = FirebaseDatabase.getInstance()
    private  var mauth:FirebaseAuth?=null
    private var bid:String?=null
    private var userid:String?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book_description)

        var bid=intent.getStringExtra("bid")
        var bookname=intent.getStringExtra("bname")
        var price=intent.getStringExtra("price")
        var sub=intent.getStringExtra("sub")
        var uid=intent.getStringExtra("userid")

        mauth = FirebaseAuth.getInstance()
        var user=mauth!!.currentUser

        val myref=database.getReference("Book")
        val data= arrayListOf<bookModel>()
        var bookdiscrecycler=findViewById<RecyclerView>(R.id.book_disc_rv)

        myref.addValueEventListener(object : ValueEventListener{
            override fun onDataChange(datasnapshot: DataSnapshot) {
                data.clear()
                var ad=bookDiscriptionAdapter(this@Book_description,data)
                if(datasnapshot.exists()) {
                    for (v in datasnapshot.children) {
                        val value = v.getValue(bookModel::class.java)
                        Log.d("key", value.toString())
                        if (value != null) {
                            data.add(value)
                        }
                    }

                    bookdiscrecycler.adapter = ad
                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })
        bookdiscrecycler.layoutManager= LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false)

    }
}