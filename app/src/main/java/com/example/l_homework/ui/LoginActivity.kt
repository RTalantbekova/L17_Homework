package com.example.l_homework.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.l_homework.MyApp
import com.example.l_homework.R
import com.example.l_homework.data.AppDB
import com.example.l_homework.data.EtData
import com.example.l_homework.data.LoginData
import kotlinx.android.synthetic.main.activity_data.*
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_login.btn_save

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        setupListeners()
    }

    private fun setupListeners() {
        btn_save.setOnClickListener {
            startActivity(Intent(applicationContext, MainActivity::class.java))
        }
        regist.setOnClickListener {
            startActivity(Intent(applicationContext, RegistActivity::class.java))
        }
    }

}