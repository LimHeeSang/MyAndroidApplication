package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.fragment.app.FragmentManager


class FragmentActivity : AppCompatActivity(), FragmentOne.onDataPassListener {

    override fun onDataPass(data: String?) {
        Log.d("pass", ""+data)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment)
        Log.d("life_cycle", "onCreate")

        val fragment1: FragmentOne = FragmentOne()
        // fragment에 data를 넣어주는 방법
        // activity -> fragment
        val bundle : Bundle = Bundle()
        bundle.putString("hello", "hello")
        fragment1.arguments = bundle


        val button : Button = findViewById(R.id.button)
        button.setOnClickListener{
            // 프라그먼트를 동적으로 작동하는 방법
            //val fragment1:Fragment1 = Fragment1()
            val fragmentManager: FragmentManager = supportFragmentManager
            // Transaction
            // 작업의 단위 -> 시작과 끝이있다
            // fragment를 container로 옮기는 동적 과정
            // fragment 붙이는 방법 replace/add
            val fragmentTransaction = fragmentManager.beginTransaction()  //시작
            fragmentTransaction.replace(R.id.container, fragment1)  //할 일
            fragmentTransaction.commit()    //끝
            //끝을 내는 방법
            // commit       -> 시간 될 때 해 (좀 더 안정정)
            // commintnow   -> 지금 당장해
        }
        val button2 : Button = findViewById(R.id.button2)
        button2.setOnClickListener {
            //val fragment1: Fragment1 = Fragment1()
            // fragment remove/detach 하는 방법 (remove: 붙혔다 뗐다 가능, detach 붙히면 뗐다 이런거 불가능)
            val fragmentManager : FragmentManager = supportFragmentManager
            val fragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.detach(fragment1)
            fragmentTransaction.commit()
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d("life_cycle", "onStart")

    }

    override fun onResume() {
        super.onResume()
        Log.d("life_cycle", "onResume")

    }

    override fun onPause() {
        super.onPause()
        Log.d("life_cycle", "onPause")

    }

    override fun onStop() {
        super.onStop()
        Log.d("life_cycle", "onStop")

    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("life_cycle", "onDestroy")

    }
}