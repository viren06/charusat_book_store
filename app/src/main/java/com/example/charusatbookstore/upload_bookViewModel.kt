package com.example.charusatbookstore

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import java.time.LocalDateTime

class upload_bookViewModel : ViewModel(){
    val database = FirebaseDatabase.getInstance()
    val myref=database.getReference("Book")
    var data=MutableLiveData<userModel>()

    fun getdata(uid: String): MutableLiveData<userModel>?{
        var myRef=database.getReference("user")
        var userprofile=object : ValueEventListener{
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                val value=dataSnapshot.getValue(userModel::class.java)
                data.value=value
                Log.d("TAG","Value is: $value")
            }

            override fun onCancelled(error: DatabaseError) {
                Log.w("TAG","Failed to read value.",error.toException())
            }
        }
        myRef.child(uid).addListenerForSingleValueEvent(userprofile)
        return data
    }

    fun savedata(
        uid: String,
        college1: String,
        department1: String,
        semester1: String,
        subjecttext: String,
        pricetext: String,
        discriptiontext: String,
        img: String,
        bookid: String,
        username: String
    ) {
        var Book=HashMap<String,Any>()
        Book["uid"]=uid
        Book["college"]=college1
        Book["department"]=department1
        Book["semester"]=semester1
        Book["subject"]=subjecttext
        Book["price"]=pricetext
        Book["discription"]=discriptiontext
        Book["img"]=img
        Book["bookid"]=bookid
        myref.child(bookid).setValue(Book)
    }


}