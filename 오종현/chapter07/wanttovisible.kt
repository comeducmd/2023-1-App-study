/**
viewBinding을 하려면 app수준의 build.bundle에서 
android{
  viewBinding {
        enabled = true
    }
}
을 활성화시켜주어야 한다.
**/
package com.dreamfilm.kotlintester

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.dreamfilm.kotlintester.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        
        binding.button.setOnClickListener {
            binding.button.visibility = View.INVISIBLE
            binding.imageView.visibility = View.VISIBLE
        }
        binding.imageView.setOnClickListener{
            binding.button.visibility = View.VISIBLE
            binding.imageView.visibility = View.INVISIBLE
        }
    }
}
