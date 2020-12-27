package com.susieson.photo.ui.settings

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.susieson.photo.R
import com.susieson.photo.common.showAlertDialog
import com.susieson.photo.databinding.ActivitySettingsBinding
import com.susieson.photo.ui.auth.AuthenticationActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SettingsActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySettingsBinding
    private val viewModel: SettingsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_settings)
        binding.signOut.setOnClickListener {
            showAlertDialog(this,
                title = R.string.sign_out,
                message = R.string.sign_out_message,
                positiveListener = { _, _ ->
                    viewModel.signOut()
                    startActivity(Intent(this, AuthenticationActivity::class.java))
                    finish()
                })
        }
        binding.deleteAccount.setOnClickListener {
            showAlertDialog(this,
                title = R.string.delete_account,
                message = R.string.delete_account_message,
                positiveListener = { _, _ ->
                    viewModel.deleteAccount()
                    startActivity(Intent(this, AuthenticationActivity::class.java))
                    finish()
                })
        }
    }
}