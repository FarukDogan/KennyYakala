package com.example.kennyyakala

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class anasayfa : AppCompatActivity() {
    var kolay="750"
    var orta ="500"
    var zor= "350"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_anasayfa)

    }
    fun kolay (view:View){
        val intent =Intent(this,MainActivity::class.java)
        intent.putExtra("seviye",kolay)

        startActivity(intent)
    }
    fun orta (view:View){

        val intent =Intent(this,MainActivity::class.java)
        intent.putExtra("seviye",orta)

        startActivity(intent)
    }
    fun zor (view:View){

        val intent =Intent(this,MainActivity::class.java)
        intent.putExtra("seviye",zor)

        startActivity(intent)
    }
}