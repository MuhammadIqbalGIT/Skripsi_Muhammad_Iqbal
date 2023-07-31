package com.example.skripsimuhammadiqbal.SplashScreen

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.example.skripsimuhammadiqbal.OnBoarding.WalkThroughActivity
import com.example.skripsimuhammadiqbal.R

class SplashScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

       Handler().postDelayed({
           val intent = Intent (this,WalkThroughActivity::class.java)
           startActivity(intent)
       },2000)
    }
}