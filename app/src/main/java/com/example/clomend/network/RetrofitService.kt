package com.example.clomend.network

import retrofit2.Call
import retrofit2.http.*

interface RetrofitService {
    @GET("/")
    fun getUser(@Query("name") name:String): Call<User>

    @POST("/")
    fun postRequest(@Field("id")id: String,
                    @Field("password")password: String):Call<User>


}