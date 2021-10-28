package com.example.todlprojectv1.view

import android.media.MediaPlayer
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.todlprojectv1.R
import com.example.todlprojectv1.repository.TodlRepository
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val clickSound = MediaPlayer.create(this, R.raw.clicksound)//This to create a media player sound
        val fab: FloatingActionButton = findViewById(R.id.floating)
        fab.setOnClickListener {
            clickSound.start()// To start the sound on clicking
            val addFragment = TodlAddFragment()
            var fragment: Fragment? = supportFragmentManager.findFragmentByTag(
                TodlAddFragment::class.java.simpleName)
            if (fragment !is TodlAddFragment){
                supportFragmentManager.beginTransaction()
                    .add(R.id.fragmentContainerView,addFragment,TodlAddFragment::class.java.simpleName).commit()
            }

        }

            TodlRepository.init(this)
    }
    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }
}


