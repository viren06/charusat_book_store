package com.example.charusatbookstore

import android.app.Activity
import android.content.DialogInterface
import android.content.Intent
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.storage.FirebaseStorage

class userbookAdapter(var ctx: Activity, var arlist: ArrayList<bookModel>): RecyclerView.Adapter<userbookAdapter.viewholder>() {
    val database = FirebaseDatabase.getInstance()
    //private var bid:String?=null
    private var bstatus:String?=null

    inner class viewholder(v: View):RecyclerView.ViewHolder(v){
        var book_name : TextView = v.findViewById(R.id.ubookname)
        var book_price : TextView = v.findViewById(R.id.ubookprice)
        var sold : Button=v.findViewById(R.id.booksold)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewholder {
        val v=ctx.layoutInflater.inflate(R.layout.userbooks_view,parent,false)
        return  viewholder(v)
    }

    override fun onBindViewHolder(holder: viewholder, position: Int) {
        holder.book_name.text=arlist[position].discription
        holder.book_price.text=arlist[position].price+"₹"

        var book=arlist[position]
        book.status="sold"
        holder.sold.setOnClickListener {
            val builder = AlertDialog.Builder(ctx)
            builder.setTitle("SOLD")
            builder.setMessage("Are you sure about selling this book?")
            builder.setPositiveButton("Yes",{ dialogInterface : DialogInterface, i : Int ->
                val myref=database.getReference("Book")
                myref.child(arlist[position].bookid.toString()).setValue(book)
                })
            builder.setNegativeButton("No",{ dialogInterface : DialogInterface, i: Int ->})
            builder.show()
        }
    }

    override fun getItemCount(): Int {
        return arlist.size
    }

}