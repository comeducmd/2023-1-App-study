package com.dreamfilm.kotlintester

import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        //textview
        val name = TextView(this).apply{
            typeface = Typeface.DEFAULT_BOLD
            text = "오종현"
        }
        
        //imageview
        val image = ImageView(this).also{
            it.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.lake_1))
        }
        
        //textview
        val address = TextView(this).apply{
            typeface - Typeface.DEFAULT_BOLD
            text = "이곳은 주소가 입력될 공간입니다"
        }
        
        //LinearLayout 
        val layout = LinearLayout(this).apply{
            orientation = LinearLayout.VERTICAL
            gravity = Gravity.CENTER
            addView(name, WRAP_CONTENT, WRAP_CONTENT)
            addView(image, WRAP_CONTENT, WRAP_CONTENT)
            addView(address, WRAP_CONTENT, WRAP_CONTENT)
        }
        setContentView(layout)
        //만약 xml과 함께 사용한다면 라벨링 필요
        val textView1 = FindViewById<TextView>(R.id.text1)
    }
}
