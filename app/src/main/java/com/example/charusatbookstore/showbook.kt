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

class showbook : AppCompatActivity() {

    val database=FirebaseDatabase.getInstance()
    private var mauth:FirebaseAuth?=null
    private lateinit var bookRecyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_showbook)
        mauth= FirebaseAuth.getInstance();
        var user=mauth!!.currentUser
        var unm=user!!.uid
        var data= arrayListOf<bookModel>()
        //var selected= arrayListOf<bookModel>()
        bookRecyclerView =findViewById(R.id.rvbook_show)

        var college=intent.getStringExtra("college")
        var department=intent.getStringExtra("department")
        var sem=intent.getStringExtra("sem")


        val myref=database.getReference("Book")
        myref.addValueEventListener(object : ValueEventListener{

            override fun onDataChange(datasnapshot: DataSnapshot) {
                data.clear()
                var ad=bookItemAdapter(this@showbook,data)
                if(datasnapshot.exists()) {
                    for (v in datasnapshot.children) {
                        val value = v.getValue(bookModel::class.java)
                        Log.d("key", value.toString())
                        if (value != null) {
                            if(value.status=="sell" && value.college==college && value.department==department && value.semester==sem ){
                                data.add(value)
                            }

                        }
                    }
                    //selected=ad.getselectedlist()
                    //bookRecyclerView.adapter=bookItemAdapter(data)
                    bookRecyclerView.adapter = ad
                }

            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })
        bookRecyclerView.layoutManager=LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)

    }
}