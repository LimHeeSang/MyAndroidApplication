package com.example.myapplication

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button

class Intent1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent)

        val change : Button = findViewById(R.id.change_activity)
        change.setOnClickListener{
            // 명시적 intent
/*
            val intent = Intent(this@intent1, intent2::class.java)      //intent1 에서 intent2로 화면 전환or 정보전달
            // key, value 방식 -> key와 value를 쌍으로 만들어 저장한다. -> Dictionary
            intent.putExtra("number1", 1)
            intent.putExtra("number2", 2)
            startActivity(intent)*/

            ///////////위와 아래는 같은 코드이나 가독성의 차이 아래것으로 추천//////////////////

            val intent2 = Intent(this@Intent1, Intent2::class.java)      //this = intent2 의미 this를 써주는게 좋음(나중에러방지)
            intent2.apply{
                this.putExtra("number1", 1)
                this.putExtra("number2", 2)
            }
            startActivityForResult(intent2, 200)    //requestCode = 내가 보낸 결과가 맞는지 int 값 넣어서 확인 용도
            // 전달만 하는 activity -> startActivity(intent)
            // 전달도 하고 받기도 하는 activity -> startActivityForResult(intent)



            // 암시적 intent
            val intent3 = Intent(Intent.ACTION_VIEW, Uri.parse("http://m.naver.com"))
            startActivity(intent3)
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {

        if(requestCode == 200){
            Log.d("number", ""+requestCode)
            Log.d("number", ""+resultCode)
            val result = data?.getIntExtra("result", 0)
        }
        super.onActivityResult(requestCode, resultCode, data)
    }


}