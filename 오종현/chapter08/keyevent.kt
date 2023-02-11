package com.dreamfilm.kotlintester

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.KeyEvent
import android.view.MotionEvent
import android.view.View
import androidx.constraintlayout.widget.ConstraintSet.Motion
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

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        //키를 누르는 순간의 이벤트
        Log.d("keyevent", "keydown")
        when (keyCode) {
            KeyEvent.KEYCODE_0 -> Log.d("keyevent", "0번 키가 눌렸어요.")
            KeyEvent.KEYCODE_A -> Log.d("keyevent", "a키가 눌렸어요.")
            //이러한 키 이벤트들은 모두 물리키에만 해당된다. 하드웨어 키보드 코딩할 때 이거로 적용시키는 듯
            KeyEvent.KEYCODE_BACK -> Log.d("keyevent", "뒤로가기 키가 눌렸어요.") 
            //back 키는 onBackPressed() 또는 api 33 이상일 때는 androidx.activity.OnBackPressed() 사용
            KeyEvent.KEYCODE_VOLUME_UP -> Log.d("keyevent", "볼륨 아래키가 눌렸어요.")
        }
        return super.onKeyDown(keyCode, event)
    }

    override fun onKeyUp(keyCode: Int, event: KeyEvent?): Boolean {
        //키를 누르고 떼는 순간의 이벤트
        Log.d("keyevent", "keyup")
        return super.onKeyUp(keyCode, event)
    }
}
