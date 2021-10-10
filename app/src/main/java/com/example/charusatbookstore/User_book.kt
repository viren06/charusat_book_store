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

class User_book : AppCompatActivity() {

    val database= FirebaseDatabase.getInstance()
    private var mauth: FirebaseAuth?=null
    private lateinit var userbookRecyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_book)

        mauth= FirebaseAuth.getInstance()
        var user=mauth!!.currentUser
        var unm=user!!.uid
        var data= arrayListOf<bookModel>()

        userbookRecyclerView =findViewById(R.id.userbook_rv)

        val myref=database.getReference("Book")
        myref.addValueEventListener(object : ValueEventListener {

            override fun onDataChange(datasnapshot: DataSnapshot) {
                data.clear()
                var ad=userbookAdapter(this@User_book,data)
                if(datasnapshot.exists()) {
                    for (v in datasnapshot.children) {
                        val value = v.getValue(bookModel::class.java)
                        Log.d("key", value.toString())
                        if (value != null) {
                            if (unm==value.uid){
                                data.add(value)
                            }

                        }
                    }
                    userbookRecyclerView.adapter = ad
                }

            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })
        userbookRecyclerView.layoutManager= LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false)

    }
}