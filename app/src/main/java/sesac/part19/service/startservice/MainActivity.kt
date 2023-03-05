package sesac.part19.service.startservice

import android.content.Intent
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val startButton = findViewById<ImageView>(R.id.startButton)
        val stopButton = findViewById<ImageView>(R.id.stopButton)

        startButton.setOnClickListener {
            val intent = Intent("PLAY_TO_SERVICE")
            intent.putExtra("mode", "start")
            sendBroadcast(intent)

            startButton.setEnabled(false)
            startButton.setEnabled(true)
        }

        stopButton.setOnClickListener {
            val intent = Intent("PLAY_TO_SERVICE")
            intent.putExtra("mode", "stop")
            sendBroadcast(intent)

            startButton.setEnabled(true)
            stopButton.setEnabled(false)
        }

        val intent = Intent(this, MyService::class.java)
        startService(intent)
    }

    override fun onDestroy() {
        super.onDestroy()
        val intent = Intent(this, MyService::class.java)
        stopService(intent)
    }
}