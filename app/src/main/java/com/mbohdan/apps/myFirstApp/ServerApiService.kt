package com.mbohdan.apps.myFirstApp

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Header

interface ServerApiService {


    @GET("profile")
    fun getProfile(@Header("Authorization")authHeader: String): Call<Profile>


    /**
     * Companion object to create the GithubApiService
     */
    companion object Factory {
        fun create(): ServerApiService {
            val retrofit = Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("http://10.0.2.2:8080/")
                .build()

            return retrofit.create(ServerApiService::class.java)
        }
    }
}