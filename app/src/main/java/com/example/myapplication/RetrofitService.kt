package com.example.myapplication

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface RetrofitService{
// baseaddress + 뒷부분을 쉽게 관리 할 수 있는 service부분
    @GET("json/students/")
    fun getStudentList(): Call<ArrayList<PersonFromServer>>

    @POST("json/students")
    fun createStudent(
        @Body params : HashMap<String, Any>
    ): Call<PersonFromServer>

    @POST("json/students")
    fun createStudenteasy(
        @Body person: PersonFromServer
    ): Call<PersonFromServer>

}