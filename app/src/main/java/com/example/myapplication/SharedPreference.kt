package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button

class SharedPreference : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shared_preference)


        //SharedPreference
        // Mode
        // - MODE_PRIVATE : 생성한 application에서만 사용가능
        // - MODE_WORLD_READABLE : 다른 application 사용가능 -> 읽을수만 있다
        // - MORE_WORLD_WRITEABLE : 다른 application 사용가능 -> 기록도 가능하다
        // - MODE_MULTI_PROCESS : 이미 호출되어 사용중인지 체크
        // - MORE_APPEND: 기존 preference에 신규로 추가

        //SharedPreference에 값을 저장하는 방법
        /*val editor = sharedPreference.edit()
        editor.putString("hello", "안녕하세요")
        editor.commit()*/

        //sp1 -> SharedPreference
        //  (Key, Value) -> ("Hello", "안녕하세요")
        //sp2 -> SharedPreference
        //  (Key, Value) -> ("Hello", "안녕하세요112")

        val save_btn:Button = findViewById(R.id.save_btn)
        save_btn.setOnClickListener {
            val sharedPreference = getSharedPreferences("sp1", MODE_PRIVATE)
            val editor = sharedPreference.edit()
            editor.putString("hello", "안녕하세요")
            editor.putString("good bye", "안녕히 가세요")
            editor.commit()
        }



        val load_btn: Button = findViewById(R.id.loat_btn)
        load_btn.setOnClickListener {
            //SharedPreference에 값을 불러오는 방법
            val sharedPreference = getSharedPreferences("sp1", MODE_PRIVATE)
            val value1 = sharedPreference.getString("hello", "데이터 없음1")
            val value2 = sharedPreference.getString("good bye", "데이터 없음2")
            Log.d("key-value", "value1 : " + value1)
            Log.d("key-value", "value2 : " + value2)
        }


        val delete_btn: Button = findViewById(R.id.delete_btn)
        delete_btn.setOnClickListener {
            val sharedPreference = getSharedPreferences("sp1", MODE_PRIVATE)
            val editor = sharedPreference.edit()
            editor.remove("hello")
            editor.commit()
        }


        val delete_all_btn: Button = findViewById(R.id.delete_all_btn)
        delete_all_btn.setOnClickListener {
            val sharedPreference = getSharedPreferences("sp1", MODE_PRIVATE)
            val editor = sharedPreference.edit()
            editor.clear()
            editor.commit()
        }

        //설정 - 앱에서 데이터를 지울 수 있음
    }
}