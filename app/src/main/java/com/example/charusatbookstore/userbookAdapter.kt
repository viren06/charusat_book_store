package com.example.charusatbookstore

import android.app.Activity
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class userbookAdapter(var ctx: Activity, var arlist: ArrayList<bookModel>): RecyclerView.Adapter<userbookAdapter.viewholder>() {

    inner class viewholder(v: View):RecyclerView.ViewHolder(v){
        var book_name : TextView = v.findViewById(R.id.ubookname)
        var book_price : TextView = v.findViewById(R.id.ubookprice)



    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewholder {
        val v=ctx.layoutInflater.inflate(R.layout.userbooks_view,parent,false)
        return  viewholder(v)
    }

    override fun onBindViewHolder(holder: viewholder, position: Int) {
        holder.book_name.text=arlist[position].discription
        holder.book_price.text=arlist[position].price+"₹"
    }

    override fun getItemCount(): Int {
        return arlist.size
    }

}