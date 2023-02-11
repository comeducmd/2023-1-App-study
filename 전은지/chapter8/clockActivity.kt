package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.view.KeyEvent
import android.widget.TextView
import android.widget.Toast
import com.example.myapplication.databinding.ActivityMainBinding
import java.lang.System.currentTimeMillis

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root) // view xml

        var pauseTime:Long = 0L

        binding.startBtn.setOnClickListener{
            binding.chronometer.base = SystemClock.elapsedRealtime() + pauseTime
            binding.chronometer.start()
            binding.stopBtn.isEnabled = true
            binding.clearBtn.isEnabled = true
            binding.startBtn.isEnabled = false
        }

        binding.stopBtn.setOnClickListener {
            pauseTime = binding.chronometer.base - SystemClock.elapsedRealtime()
            binding.chronometer.stop()
            binding.startBtn.isEnabled = true
            binding.stopBtn.isEnabled = false
        }

        binding.clearBtn.setOnClickListener {
            binding.chronometer.stop()
            binding.chronometer.base = SystemClock.elapsedRealtime()
            pauseTime = 0L
            binding.startBtn.isEnabled = true
            binding.stopBtn.isEnabled = false
            binding.clearBtn.isEnabled = false
        }
    }

    var backTime:Long = 0L

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (System.currentTimeMillis() - backTime > 3000) {
                Toast.makeText(this, "종료하려면 한번 더 누르세요 메롱", Toast.LENGTH_SHORT).show()
                backTime = System.currentTimeMillis()
                return true
            }
        }
        return super.onKeyDown(keyCode, event)
    }
}
