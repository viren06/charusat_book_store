package com.example.charusatbookstore

import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.google.firebase.auth.FirebaseAuth



class college : AppCompatActivity() {

    override fun onStart(){
        super.onStart()
        var user=FirebaseAuth.getInstance().currentUser
        if(user==null)
            startActivity(Intent(this,login::class.java))

    }
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
    //otion menue
    override fun onCreateOptionsMenu (menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu,menu)
        return true
    }
    //option menue commands and next activity
    override fun onOptionsItemSelected(item: MenuItem):Boolean{
        return when(item.itemId){
            R.id.logout->{
                FirebaseAuth.getInstance().signOut()
                val builder = AlertDialog.Builder(this)
                builder.setTitle("LOGOUT")
                builder.setMessage("Do You want to logout from Applicatiom?")
                builder.setPositiveButton("Yes",{ dialogInterface : DialogInterface, i : Int ->
                    finish()
                    startActivity(Intent(this, login::class.java))})
                builder.setNegativeButton("No",{dialogInterface : DialogInterface, i: Int ->})
                builder.show()
                true
            }
            R.id.edit->{
                startActivity(Intent(this, Edit_profile::class.java))
                true
            }
            R.id.ubook->{
                startActivity(Intent(this,upload::class.java))
                true
            }
            R.id.mybooks->{
                startActivity(Intent(this,User_book::class.java))
                true
            }
            else ->super.onOptionsItemSelected(item)

        }
    }

}