package com.example.clomend.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import com.example.clomend.R
import com.example.clomend.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

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
}
