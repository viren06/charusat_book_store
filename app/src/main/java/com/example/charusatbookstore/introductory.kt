package com.example.charusatbookstore

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.airbnb.lottie.LottieAnimationView


class introductory : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_introductory)
        val logo = findViewById<ImageView>(R.id.blackbookid)
        val lottieAnimationView = findViewById<LottieAnimationView>(R.id.lottie)
        val splashimg = findViewById<ImageView>(R.id.image)

        splashimg.animate().setDuration(1000).setStartDelay(4000)
        logo.animate().setDuration(1000).setStartDelay(4000)
        lottieAnimationView.animate().setDuration(1000).setStartDelay(4000)
    }
}


