package com.example.myapplication

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.Button
import android.widget.EditText

class EditTextPractice : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edittext_practice)

        val textedit : EditText = findViewById(R.id.address_edit_text)
        val open:Button = findViewById(R.id.open)
        open.setOnClickListener{
            val url = textedit.text.toString()
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            startActivity(intent)

        }

        textedit.addTextChangedListener(object : TextWatcher{   //익명함수 - 사용자가 키보드로 값을 입력했을때의 변화(ex이메일 형태나, 개발자 지정요구 조건 충족여부)를 감지하여 프로그래밍 가능
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                //TODO("Not yet implemented")
                if(s.toString() == "abc"){
                    Log.d("edit", "text is abc")
                }
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                //TODO("Not yet implemented")
                if(s.toString() == "abc"){
                    Log.d("edit", "text is abc")
                }
            }

            override fun afterTextChanged(s: Editable?) {
                //TODO("Not yet implemented")
                if(s.toString() == "abc"){
                    Log.d("edit", "text is abc")
                }
            }
        })

    }
}