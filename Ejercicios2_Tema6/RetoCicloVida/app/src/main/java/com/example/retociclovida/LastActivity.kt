package com.example.retociclovida

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import kotlin.system.exitProcess

class LastActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_last)
    }
    override fun onStart() {
            super.onStart()
            Log.d("Lifecycle", "LastActivity - onStart")
        }

    override fun onResume() {
            super.onResume()
            Log.d("Lifecycle", "LastActivity - onResume")
        }

    override fun onPause() {
            super.onPause()
            Log.d("Lifecycle", "LastActivity - onPause")
        }

    override fun onStop() {
            super.onStop()
            Log.d("Lifecycle", "LastActivity - onStop")
        }

    override fun onRestart() {
            super.onRestart()
            Log.d("Lifecycle", "LastActivity - onRestart")
        }

    override fun onDestroy() {
            super.onDestroy()
            Log.d("Lifecycle", "LastActivity - onDestroy")
        }

        fun closeProcess() {
            exitProcess(0)
        }



}