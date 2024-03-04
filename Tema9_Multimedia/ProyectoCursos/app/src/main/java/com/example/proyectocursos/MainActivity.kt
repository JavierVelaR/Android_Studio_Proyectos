package com.example.proyectocursos

import android.annotation.SuppressLint
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.VideoView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val videoView = findViewById<VideoView>(R.id.video_view)

        // Configura los controles de reproducción del video
        val mediaController = android.widget.MediaController(this)
        videoView.setMediaController(mediaController)
        mediaController.setAnchorView(videoView)

        val buttonPlay = findViewById<Button>(R.id.button_play)
        val buttonPlay2 = findViewById<Button>(R.id.button_play2)

        // Especifica la ruta de los videos
        val videoPath = "android.resource://${packageName}/${R.raw.jv_elden_ring}"
        val videoPath2 = "android.resource://${packageName}/${R.raw.victor_joel}"
        val videoUri = Uri.parse(videoPath)
        val videoUri2 = Uri.parse(videoPath2)

        buttonPlay.setOnClickListener {
            // Configura el VideoView para reproducir el primer video y lo inicia
            videoView.setVideoURI(videoUri)
            videoView.start()
        }

        buttonPlay2.setOnClickListener {
            // Configura el VideoView para reproducir el segundo video y lo inicia
            videoView.setVideoURI(videoUri2)
            videoView.start()
        }
    }
}



