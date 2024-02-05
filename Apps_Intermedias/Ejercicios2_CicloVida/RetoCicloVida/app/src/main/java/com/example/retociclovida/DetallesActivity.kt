package com.example.retociclovida

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View

class DetallesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalles)
    }

        override fun onStart() {
            super.onStart()
            Log.d("Lifecycle", "DetallesActivity - onStart")
        }

        override fun onResume() {
            super.onResume()
            Log.d("Lifecycle", "DetallesActivity - onResume")
        }

        override fun onPause() {
            super.onPause()
            Log.d("Lifecycle", "DetallesActivity - onPause")
        }

        override fun onStop() {
            super.onStop()
            Log.d("Lifecycle", "DetallesActivity - onStop")
        }

        override fun onRestart() {
            super.onRestart()
            Log.d("Lifecycle", "DetallesActivity - onRestart")
        }

        override fun onDestroy() {
            super.onDestroy()
            Log.d("Lifecycle", "DetallesActivity - onDestroy")
        }

        fun goToSecondActivity(view: View) {
            val intent = Intent(this, LastActivity::class.java)
            startActivity(intent)
        }



}