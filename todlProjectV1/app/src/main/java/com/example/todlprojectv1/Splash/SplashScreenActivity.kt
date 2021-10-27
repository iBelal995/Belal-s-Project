package com.example.todlprojectv1.Splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.example.todlprojectv1.view.MainActivity
import com.example.todlprojectv1.R


class SplashScreenActivity : AppCompatActivity() {

            lateinit var handler: Handler
            override fun onCreate(savedInstanceState: Bundle?) {
                super.onCreate(savedInstanceState)
                setContentView(R.layout.activity_splash_screen)

                handler = Handler()
                handler.postDelayed({

                    // Delay and Start Activity
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                    finish()
                } , 1000) // here we're delaying to startActivity after 3seconds
            }
    }
