//package com.example.clomend.network
//
//import android.os.Bundle
//import android.util.Log
//import androidx.appcompat.app.AppCompatActivity
//import com.example.clomend.R
//import retrofit2.Call
//import retrofit2.Callback
//import retrofit2.Response
//import retrofit2.Retrofit
//import retrofit2.converter.gson.GsonConverterFactory
//
//class MainActivity : AppCompatActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//
//        val retrofit = Retrofit.Builder().baseUrl("http://clomend.shop/")
//            .addConverterFactory(GsonConverterFactory.create()).build();
//        val service = retrofit.create(RetrofitService::class.java);
//
//        service.getUser("")?.enqueue(object : Callback<User> {
//            override fun onResponse(call: Call<User>, response: Response<User>) {
//                if(response.isSuccessful){
//                    // 정상적으로 통신이 성고된 경우
//                    var result: User? = response.body()
//                    Log.d("YMC", "onResponse 성공: " + result?.toString());
//                }else{
//                    // 통신이 실패한 경우(응답코드 3xx, 4xx 등)
//                    Log.d("YMC", "onResponse 실패")
//                }
//            }
//
//            override fun onFailure(call: Call<User>, t: Throwable) {
//                // 통신 실패 (인터넷 끊킴, 예외 발생 등 시스템적인 이유)
//                Log.d("YMC", "onFailure 에러: " + t.message.toString());
//            }
//        })
//    }
//}

//<?xml version="1.0" encoding="utf-8"?>
//<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
//xmlns:app="http://schemas.android.com/apk/res-auto"
//xmlns:tools="http://schemas.android.com/tools"
//android:layout_width="match_parent"
//android:layout_height="match_parent"
//tools:context=".main.MainActivity"
//android:orientation="vertical">
//
//<TextView
//android:layout_width="match_parent"
//android:layout_height="wrap_content"
//android:text="Hello World!"
//android:visibility="visible"
//android:background="#00F0F0"/>
//
//<ListView
//android:id="@+id/lv_listview"
//android:layout_width="match_parent"
//android:layout_height="wrap_content"/>
//
//</LinearLayout>