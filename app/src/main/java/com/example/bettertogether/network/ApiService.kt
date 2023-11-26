package com.example.bettertogether.network

import okhttp3.RequestBody
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {

    @POST("signUpCompany")
    fun signUpCompany(@Body requestBody: RequestBody): Call<ResponseBody>

    @POST("loginCompany")
    fun loginCompany(@Body requestBody: RequestBody): Call<ResponseBody>

}
