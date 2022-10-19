package com.example.myapplication

import android.app.Application
import android.content.Context
import com.facebook.stetho.okhttp3.StethoInterceptor
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MasterApplication : Application(){ /*activity보다 상위의 개념 application에 등록 레트로핏과 관련된거 다른 activity에 걸쳐 전반적으로 다루고 싶을때 application단이 더 먼져 호출함을 의미*/

    lateinit var service: RetrofitService

    override fun onCreate() {
        super.onCreate()

        createRetrofit()
    }

    fun createRetrofit(){
        val header = Interceptor{
            val original = it.request()

            if(checkIsLogin()){
                getUserToken()?.let {token ->
                    val request = original.newBuilder()
                        .header("Authorization", "token " + token)
                        .build()
                    it.proceed(request)
                }
            }else{
                it.proceed(original)
            }

        }

        val client = OkHttpClient.Builder()
            .addInterceptor(header)
            .addNetworkInterceptor(StethoInterceptor())
            .build()

        val retrofit = Retrofit.Builder()
            .baseUrl("http://mellowcode.org/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()

        service = retrofit.create(RetrofitService::class.java)
    }



    fun checkIsLogin(): Boolean{
        val sp = getSharedPreferences("Login_sp", Context.MODE_PRIVATE)
        val token = sp.getString("login_sp", "null")
        if(token != "null") return true
        else return false
    }

    fun getUserToken(): String?{
        val sp = getSharedPreferences("Login_sp", Context.MODE_PRIVATE)
        val token = sp.getString("login_sp", "null")
        if(token == "null") return null
        else return token
    }


}