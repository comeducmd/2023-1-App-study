package com.dreamfilm.kotlintester

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
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
    override fun onTouchEvent(event: MotionEvent?): Boolean{
        when (event?.action){
            MotionEvent.ACTION_DOWN -> {
                Log.d("whichEvent", "화면을 손가락으로 누른 순간의 이벤트")
                Log.d("event position", "Touch down event x: ${event.x}, rawX: ${event.rawX}")
                //event.x는 뷰 내부에서의 x좌표(container 만들었으면 그 속에서 어느 위치 클릭한건지)
                //event.rawx는 실제 화면 끝지점에서부터의 x좌표
                //그러나 게임이나 그림판이 아니고서야 좌표값은 잘 사용 안할듯
            }
            MotionEvent.ACTION_UP -> {
                Log.d("whichEvent", "화면에서 손가락을 떼는 순간의 이벤트")
            }
            MotionEvent.ACTION_MOVE -> {
                Log.d("whichEvent", "화면을 손가락으로 누른 채 이동하는 순간의 이벤트")
            }
        }
        return super.onTouchEvent(event)
    }
}
