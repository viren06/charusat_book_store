package com.example.charusatbookstore

import android.app.Activity
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.google.firebase.storage.FirebaseStorage

class bookItemAdapter(var ctx:Activity, var arlist: ArrayList<bookModel>):RecyclerView.Adapter<bookItemAdapter.viewholder>(){

    inner class viewholder(v:View):RecyclerView.ViewHolder(v){
        var bookname : TextView = v.findViewById(R.id.book)
        var price : TextView = v.findViewById(R.id.price)
        var subjectname : TextView=v.findViewById(R.id.sub)
        var bookimage : ImageView =v.findViewById(R.id.img)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewholder {
        //val v=LayoutInflater.from(parent.context).inflate(R.layout.show_book_view,parent,false)
        val v=ctx.layoutInflater.inflate(R.layout.show_book_view,parent,false)
        return  viewholder(v)
    }

    override fun onBindViewHolder(holder: viewholder, position: Int) {
        var currentitem = arlist[position]


        holder.bookname.text=arlist[position].discription
        holder.price.text=arlist[position].price+"₹"
        holder.subjectname.text=arlist[position].subject

        if(arlist[position].img.toString()!=""){
            val storage =FirebaseStorage.getInstance()
            val storageReference =storage.getReferenceFromUrl(arlist[position].img.toString())

            storageReference.downloadUrl.addOnSuccessListener {
                val img=it.toString()
                Glide.with(ctx).load(img).into(holder.bookimage).view
            }
        }
        holder.itemView.setOnClickListener{
            //var int1=Intent(ctx,)
        }


    }

    override fun getItemCount(): Int {
        return arlist.size
    }

}