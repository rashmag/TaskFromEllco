package com.example.mydsu.presentation.splash_screen

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.taskfromellco.databinding.ActivitySplashScreenBinding
import com.example.taskfromellco.presentation.main_activity.MainActivity
import com.example.taskfromellco.utils.animStepForwardTransparent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashScreen : AppCompatActivity() {
    lateinit var binding: ActivitySplashScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setTime()
    }

    private fun setTime() {
        CoroutineScope(Dispatchers.Main).launch {
            try {
                delay(700)
            } catch (e: Exception) {
                e.printStackTrace()
            } finally {
                startActivity(Intent(this@SplashScreen, MainActivity::class.java))
                this@SplashScreen.animStepForwardTransparent()
            }
        }
    }
}