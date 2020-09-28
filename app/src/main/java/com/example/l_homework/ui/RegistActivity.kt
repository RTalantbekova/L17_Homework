package com.example.l_homework.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.l_homework.MyApp
import com.example.l_homework.R
import com.example.l_homework.data.AppDB
import com.example.l_homework.data.LoginData
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
            if (isNotEmpty() && isPassSimilar()){
                MyApp.app?.getDB()?.getAuthDao()?.addAndDelete(
                    LoginData(
                        id = 1,
                        userName = txt_loginRegist.text.toString(),
                        password = txt_passRegist.text.toString()
                    )
                )
                startActivity(Intent(this,MainActivity::class.java))
                finish()
            } else {
                Toast.makeText(this, "Введите верные данные", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun isPassSimilar() =
        txt_passRegist.text.toString() == txt_passRepeat.text.toString()

    private fun isNotEmpty() : Boolean{
        val resultLog = txt_loginRegist.text.toString().length > 6
        val resultPass = txt_passRegist.text.toString().length > 7
        val resultRepeatPass = txt_passRepeat.text.toString().length > 7

        return resultLog && resultPass && resultRepeatPass
    }

}