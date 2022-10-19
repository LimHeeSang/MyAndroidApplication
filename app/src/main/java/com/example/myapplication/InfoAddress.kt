package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class InfoAddress : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info_address)


        val info_name: TextView = findViewById(R.id.info_name)
        val info_number: TextView = findViewById(R.id.info_number)

        //val name = intent.getIntExtra("name")
        //val resultIntent = Intent()
        info_name.setText(intent.getStringExtra("name"))
        info_number.setText(intent.getStringExtra("phone_number"))

        /*back.setOnClickListener{
            onBackPressed()     //폰화면성 물리적으로 뒤로가기버튼과 동일한 기능적용
        }*/

    }
}