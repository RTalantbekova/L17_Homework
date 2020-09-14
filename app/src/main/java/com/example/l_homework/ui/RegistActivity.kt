package com.example.l_homework.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.l_homework.MyApp
import com.example.l_homework.R
import com.example.l_homework.data.AppDB
import com.example.l_homework.data.LoginData
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_regist.*
private var db : AppDB? = null
class RegistActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_regist)
        setupListeners()
        db = MyApp.app?.getDB()
    }

    private fun setupListeners() {
        btn_regist.setOnClickListener {
            db?.getAuthDao()?.insertData(SaveData())
            startActivity(Intent(applicationContext, MainActivity::class.java))
        }
    }

    private fun SaveData() : LoginData {
        return LoginData(
            userName = txt_loginRegist.text.toString(),
            password = txt_passRegist.text.toString()
        )
    }
}