package com.example.charusatbookstore

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import com.google.firebase.auth.FirebaseAuth

class depstardepartment : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_depstardepartment)
        var college= intent.getStringExtra("college")

        val ib=findViewById<Button>(R.id.button6)
        ib.setOnClickListener {
            val Intent= Intent(this,sem::class.java)
            Intent.putExtra("department","CE")
            Intent.putExtra("college",college)
            startActivity(Intent)
        }
        val ib1=findViewById<Button>(R.id.button7)
        ib1.setOnClickListener {
            val Intent= Intent(this,sem::class.java)
            Intent.putExtra("department","CSE")
            Intent.putExtra("college",college)
            startActivity(Intent)
        }
        val ib2=findViewById<Button>(R.id.button8)
        ib2.setOnClickListener {
            val Intent= Intent(this,sem::class.java)
            Intent.putExtra("department","IT")
            Intent.putExtra("college",college)
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
                builder.setNegativeButton("No",{ dialogInterface : DialogInterface, i: Int ->})
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