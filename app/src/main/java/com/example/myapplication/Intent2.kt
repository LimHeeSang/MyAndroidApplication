package com.example.myapplication

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button

class Intent2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent2)


        val result: Button = findViewById(R.id.result)
        result.setOnClickListener{
            val number1 = intent.getIntExtra("number1", 0)
            val number2 = intent.getIntExtra("number2", 0)

            Log.d("number", ""+number1)
            Log.d("number", ""+number2)

            val sum = number1 + number2
            val resultIntent = Intent() //여기 괄호안은 왜 안채워주는지 몰겠음..
            resultIntent.putExtra("result", sum)

            setResult(Activity.RESULT_OK, resultIntent)
            this.finish()    //-> Activity 종료

            // Stack
            // intent2 -> 종료
            // intent1
        }
    }
}