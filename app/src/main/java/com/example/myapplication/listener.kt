package com.example.myapplication

import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.TextView



class listener : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listener)

        var number = 10


        // 뷰를 activity로 가져오는 방법
        // 1> 직접 찾아서 가져온다
        val textView : TextView = findViewById(R.id.hello)
        // 2> xml을 import해서 가져온다
        // 왜 안돼지... 현재버전에서 지원이 끊긴거 같음.

        // 1 -> 람다 방식
        textView.setOnClickListener {
            Log.d("click", "click")
        }

        // 2 -> 익명함수 방식
        textView.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                Log.d("click", "click")
            }
        })

        // 3 -> 이름이 필요한 경우(click) 일반적인 방법 원래
        val click = object : View.OnClickListener{
            override fun onClick(v: View?) {
                Log.d("click", "click")
                textView.setText("안녕하세요")

                number += 10
                Log.d("number", ""+number)
            }
        }
        textView.setOnClickListener(click)

        // 뷰를 조작하는 함수들
        val image : ImageView = findViewById(R.id.image)
        image.setImageResource(R.drawable.solid)


    }
}