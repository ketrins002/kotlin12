package com.rcompany.kotlin11

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import java.util.Timer
import kotlin.concurrent.schedule

class SplashWindow : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash_window)

        Timer().schedule(3000) {
            startActivity(Intent(this@SplashWindow, MainActivity::class.java))   // Переходим на MainActivity
            finish()
        }
    }
}