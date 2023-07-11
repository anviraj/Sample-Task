package com.example.userapplication.retrofit

import com.example.userapplication.data.UserModel
import retrofit2.Call
import retrofit2.http.GET

interface RetroServiceInterface {

    @GET("users")
    fun getUserApplication(): Call<UserModel>
}