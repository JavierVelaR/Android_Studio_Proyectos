package com.example.ciclovida2

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlin.system.exitProcess

class ActivityD : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_d)
        Log.d("Lifecycle", "onCreate D")
    }

    override fun onStart() {
        super.onStart()
        Log.d("Lifecycle", "onStart D")
    }

    override fun onResume() {
        super.onResume()
        Log.d("Lifecycle", "onResume D")
    }

    override fun onPause() {
        super.onPause()
        Log.d("Lifecycle", "onPause D")
    }

    override fun onStop() {
        super.onStop()
        Log.d("Lifecycle", "onStop D")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("Lifecycle", "onRestart D")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("Lifecycle", "onDestroy D")
    }

    fun onNextButtonClick(view: View) {
        exitProcess(0)
    }
}