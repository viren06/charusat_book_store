package com.example.charusatbookstore

import android.app.Activity
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.google.firebase.storage.FirebaseStorage

class bookDiscriptionAdapter (var ctx:Activity, var arrayList: ArrayList<bookModel>):RecyclerView.Adapter<bookDiscriptionAdapter.viewholder>(){

    inner class viewholder (v:View):RecyclerView.ViewHolder(v){
        var bookname : TextView = v.findViewById(R.id.bname)
        var price : TextView = v.findViewById(R.id.Price)
        var subjectname : TextView =v.findViewById(R.id.Sub)
        var bookimage : ImageView =v.findViewById(R.id.bookimg)
        var username : TextView=v.findViewById(R.id.User)
        var UserEmail : TextView=v.findViewById(R.id.Uemail)
        var Usernum: TextView=v.findViewById(R.id.Unum)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewholder {
        val v=ctx.layoutInflater.inflate(R.layout.book_discription_view,parent,false)
        return  viewholder(v)
    }

    override fun onBindViewHolder(holder: viewholder, position: Int) {
        holder.bookname.text=arrayList[position].discription
        holder.price.text=arrayList[position].price+"₹"
        holder.subjectname.text=arrayList[position].subject
        holder.username.text=arrayList[position].uid

        if(arrayList[position].img.toString()!=""){
            val storage = FirebaseStorage.getInstance()
            val storageReference =storage.getReferenceFromUrl(arrayList[position].img.toString())

            storageReference.downloadUrl.addOnSuccessListener {
                val img=it.toString()
                Glide.with(ctx).load(img).into(holder.bookimage).view
            }
        }
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }
}