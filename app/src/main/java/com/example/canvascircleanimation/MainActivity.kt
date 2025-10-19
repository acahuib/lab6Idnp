package com.example.canvascircleanimation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    private lateinit var circleView: CircleView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        circleView = findViewById(R.id.circleView)
        val btnAnimate = findViewById<Button>(R.id.btnAnimate)

        btnAnimate.setOnClickListener {
            circleView.toggleAnimation()
        }
    }
}
