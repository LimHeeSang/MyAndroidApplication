package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.bumptech.glide.Glide

class LibraryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_library)

        val glide: ImageView = findViewById(R.id.glide)
        val glide2: ImageView = findViewById(R.id.glide2)
        Glide.with(this)
            .load("https://search.pstatic.net/common/?src=http%3A%2F%2Fshop1.phinf.naver.net%2F20190304_90%2Fskylove8228_1551663938382HUx4n_JPEG%2F34295118037548193_748869977.jpg&type=a340")
            .centerCrop()   //imageview에 꽉채워주는 함수/등등 다양한 함수 존재1
            .into(glide)


        Glide.with(this)
            .load("https://search.pstatic.net/common/?src=http%3A%2F%2Fshop1.phinf.naver.net%2F20190304_90%2Fskylove8228_1551663938382HUx4n_JPEG%2F34295118037548193_748869977.jpg&type=a340")
            .into(glide2)

    }
}