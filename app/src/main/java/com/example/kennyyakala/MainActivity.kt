package com.example.kennyyakala

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {
    lateinit var sharedPreferences: SharedPreferences
    var score = 0
    var seviye:Long =500

    var highscore = 0



    var imageArray =ArrayList<ImageView>()
    var handler =Handler()
    var runnable = Runnable{ }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        sharedPreferences=this.getSharedPreferences("com.example.kennyyakala",Context.MODE_PRIVATE)
       var kayit= sharedPreferences.getInt("yuksek",0)
        highscore=kayit.toInt()

        
       var gelen= intent?.getStringExtra("seviye")
        gelen?.toLong()
        seviye= gelen!!.toLong()


        tvdegisken.text =highscore.toString()



        imageArray.add(imageView)
        imageArray.add(imageView2)
        imageArray.add(imageView3)
        imageArray.add(imageView4)
        imageArray.add(imageView5)
        imageArray.add(imageView6)
        imageArray.add(imageView7)
        imageArray.add(imageView8)
        imageArray.add(imageView9)
        imageArray.add(imageView10)
        imageArray.add(imageView11)
        imageArray.add(imageView12)
        gorselgizle()


        object  : CountDownTimer(15500,1000){
            override fun onTick(millisUntilFinished: Long) {

                tvTime.text="Time :"+millisUntilFinished/1000
            }

            override fun onFinish() {
tvTime.text = "Time = 0"
                handler.removeCallbacks(runnable)
                for (image in imageArray){
                    image.visibility=View.INVISIBLE
                }

                val alert =AlertDialog.Builder(this@MainActivity)
                alert.setTitle("Oyun Bitti Aslan Parçası")
                alert.setMessage("Kendimi Şanslı Hissediyomusun ?")
                alert.setPositiveButton("Evet"){dialog,which ->
                    val intent = intent

                    finish()
                    startActivity(intent)

                }
                alert.setNegativeButton("Benden Bi Cacık Olmaz"){ dialog,which ->
                    Toast.makeText(this@MainActivity,"Savaşmaya Cesaretin bile yok LOSERRRR",Toast.LENGTH_LONG).show()
                    val intent =Intent(this@MainActivity,anasayfa::class.java)
                    finish()
                    startActivity(intent)

                }
                alert.show()


                if (score>=highscore){
                    highscore=score
                    tvdegisken.text=highscore.toString()
                    sharedPreferences.edit().putInt("yuksek",highscore).apply()

                }
            }

        }.start()


    }
    fun gorselgizle (){

        runnable= object  :Runnable{
            override  fun run () {

                for (image in imageArray){
                    image.visibility = View.INVISIBLE
                }

                val random = Random()
                val randomIndex = random.nextInt(9)
                imageArray[randomIndex].visibility=View.VISIBLE

                handler.postDelayed(runnable, seviye.toLong())
            }
        }
        handler.post (runnable)


    }

    fun scorearttir (view : View) {
        score ++
        tvscore.text = "Score: $score"


    }
    fun yenile (view: View){
        val intent = intent

        finish()
        startActivity(intent)
    }
    fun home (view: View){
        val intent =Intent(this,anasayfa::class.java)

finish()
        startActivity(intent)
    }
}





