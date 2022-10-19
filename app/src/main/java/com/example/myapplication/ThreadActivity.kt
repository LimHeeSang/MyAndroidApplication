package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button

class ThreadActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_thread)


        val runnable: Runnable = object : Runnable{ //쓰레드가 할 일을 runnable에 입력
            override fun run() {
                Log.d("thread-1", "Thread is made")
            }
        }
        val thread: Thread = Thread(runnable)   //runnable을 쓰레드에 적용


        val button: Button = findViewById(R.id.button)
        button.setOnClickListener {
            thread.start()
        }

        Thread(object : Runnable{
            override fun run() {
                Log.d("thread-2", "Thread2 is made")
            }
        }).start()
        // 람다방식식
       Thread(Runnable {
            Log.d("thread-3", "Thread3 is made")
            Thread.sleep(2000)
            runOnUiThread({
                button.setBackgroundColor(getColor(R.color.text_color)) //메인쓰레드 외의 다른 쓰레드가 ui를 건드리면 앱크래쉬발생
            })
        }).start()


    }
}