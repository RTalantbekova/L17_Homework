package com.example.l_homework.ui

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.l_homework.MyApp
import com.example.l_homework.R
import com.example.l_homework.data.AppDB
import com.example.l_homework.data.EtData
import com.example.l_homework.data.LoginData
import kotlinx.android.synthetic.main.activity_data.*
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_login.btn_log

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val preference = getSharedPreferences("share", Context.MODE_PRIVATE)
        if (preference.getBoolean("autoEnter", false)){
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
        setContentView(R.layout.activity_login)
        setupListeners(preference)
    }

    private fun setupListeners(preferences: SharedPreferences) {
        btn_log.setOnClickListener {
            if (isNotEmpty())
            {
                val result =
                    MyApp.app?.getDB()?.getAuthDao()?.getUser(
                        getLogin(),
                        getPassword()
                )

                if(result != null){
                    preferences.edit().putBoolean("autoEnter", autoSave.isChecked).apply()
                    startActivity(Intent(applicationContext, MainActivity::class.java))
                    finish()
                } else
                { Toast.makeText(this,"Введите верные данные", Toast.LENGTH_SHORT).show()}

            } else{
                Toast.makeText(this, "Введите верные данные", Toast.LENGTH_SHORT).show()
            }

        }
        regist.setOnClickListener {
            startActivity(Intent(applicationContext, RegistActivity::class.java))
        }
    }

    private fun getLogin() = txt_login.text.toString()
    private fun getPassword() = txt_pass.text.toString()

    private fun isNotEmpty() : Boolean {
        val resultLogin = getLogin().length > 6
        val resultPass = getPassword().length > 7
        return resultLogin && resultPass
    }

}