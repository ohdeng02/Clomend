package com.example.clomend.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import com.example.clomend.R
import com.example.clomend.closet.ClosetFragment
import com.example.clomend.community.CommunityFragment
import com.example.clomend.data.RetrofitService
import com.example.clomend.data.User
import com.example.clomend.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        replaceCommunityFragment(CommunityFragment())
        replaceClosetFragment(ClosetFragment())

//        val retrofit = Retrofit.Builder().baseUrl("https://Clomend.shop/")
//            .addConverterFactory(GsonConverterFactory.create()).build();
//
//        val service = retrofit.create(RetrofitService::class.java);
//
//
//        service.getUserPage("1")?.enqueue(object : Callback<User> {
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
//            override fun onFailure(call: Call<User>, t: Throwable) {
//                // 통신 실패 (인터넷 끊킴, 예외 발생 등 시스템적인 이유)
//                Log.d("YMC", "onFailure 에러: " + t.message.toString());
//            }
//        })

        val controller = findNavController(R.id.navigation_host)

        NavigationUI.setupWithNavController(binding.bottomNavigation, controller)

        controller.addOnDestinationChangedListener { _, destination, _ ->
            if (arrayListOf(R.id.splashFragment, R.id.loginFragment,R.id.info_InputFragment,R.id.registerFragment,
                R.id.clothesAddFragment).contains(destination.id)) {
                binding.bottomNavigation.visibility = View.GONE
            } else {
                binding.bottomNavigation.visibility = View.VISIBLE
            }
        }
    }
    private fun replaceCommunityFragment(CommunityFragment : Fragment){
        val fragmentManager = supportFragmentManager
        val fragmentTransaction= fragmentManager.beginTransaction()
        fragmentTransaction.commit()
    }
    private fun replaceClosetFragment(ClosetFragment : Fragment){
        val fragmentManager = supportFragmentManager
        val fragmentTransaction= fragmentManager.beginTransaction()
        fragmentTransaction.commit()
    }
}
