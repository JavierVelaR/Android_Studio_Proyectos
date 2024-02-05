package com.example.ciclovida2

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class ActivityB : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_b)
        Log.d("Lifecycle", "onCreate B")
    }

    override fun onStart() {
        super.onStart()
        Log.d("Lifecycle", "onStart B")
    }

    override fun onResume() {
        super.onResume()
        Log.d("Lifecycle", "onResume B")
    }

    override fun onPause() {
        super.onPause()
        Log.d("Lifecycle", "onPause B")
    }

    override fun onStop() {
        super.onStop()
        Log.d("Lifecycle", "onStop B")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("Lifecycle", "onRestart B")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("Lifecycle", "onDestroy B")
    }

    fun onNextButtonClick(view: View) {
        startActivity(Intent(this, ActivityC::class.java))
    }
}