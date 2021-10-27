package com.example.todlprojectv1.view

import android.media.MediaPlayer
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.todlprojectv1.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val clickSound = MediaPlayer.create(this, R.raw.clicksound)//This to create a media player sound
        val fab: View = findViewById(R.id.floating)
        fab.setOnClickListener {
            clickSound.start()// To start the sound on clicking
            Toast.makeText(this,"Hi", Toast.LENGTH_SHORT).show()
        }

    }
}