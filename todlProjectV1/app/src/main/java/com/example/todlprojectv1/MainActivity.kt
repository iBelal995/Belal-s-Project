package com.example.todlprojectv1

import android.media.MediaPlayer
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val clicksound = MediaPlayer.create(this,R.raw.clicksound)
        val fab: View = findViewById(R.id.floating)
        fab.setOnClickListener {
            clicksound.start()
            Toast.makeText(this,"Hi", Toast.LENGTH_SHORT).show()
        }

    }
}