package com.susieson.food.ui.splash

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.susieson.food.R
import com.susieson.food.databinding.ActivitySplashBinding
import com.susieson.food.ui.auth.AuthenticationActivity
import com.susieson.food.ui.main.MainActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SplashActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySplashBinding
    private val viewModel: SplashViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_splash)
        viewModel.user.observe(this) {
            if (it == null) startAuth() else startMain()
        }
    }

    private fun startAuth() {
        startActivity(Intent(this, AuthenticationActivity::class.java))
    }

    private fun startMain() {
        startActivity(Intent(this, MainActivity::class.java))
    }
}