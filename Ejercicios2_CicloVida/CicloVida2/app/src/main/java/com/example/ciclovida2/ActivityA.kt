package com.example.ciclovida2

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class ActivityA : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_activity)
        Log.d("Lifecycle", "onCreate A")
    }

    override fun onStart() {
        super.onStart()
        Log.d("Lifecycle", "onStart A")
    }

    override fun onResume() {
        super.onResume()
        Log.d("Lifecycle", "onResume A")
    }

    override fun onPause() {
        super.onPause()
        Log.d("Lifecycle", "onPause A")
    }

    override fun onStop() {
        super.onStop()
        Log.d("Lifecycle", "onStop A")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("Lifecycle", "onRestart A")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("Lifecycle", "onDestroy A")
    }

    fun onNextButtonClick(view: View) {
        startActivity(Intent(this, ActivityB::class.java))
    }
}