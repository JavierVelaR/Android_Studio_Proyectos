package com.example.ciclovida2

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class ActivityC : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_c)
        Log.d("Lifecycle", "onCreate C")
    }

    override fun onStart() {
        super.onStart()
        Log.d("Lifecycle", "onStart C")
    }

    override fun onResume() {
        super.onResume()
        Log.d("Lifecycle", "onResume C")
    }

    override fun onPause() {
        super.onPause()
        Log.d("Lifecycle", "onPause C")
    }

    override fun onStop() {
        super.onStop()
        Log.d("Lifecycle", "onStop C")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("Lifecycle", "onRestart C")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("Lifecycle", "onDestroy C")
    }

    fun onNextButtonClick(view: View) {
        startActivity(Intent(this, ActivityD::class.java))
    }
}