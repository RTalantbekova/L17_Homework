package com.example.l_homework.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.l_homework.MyApp
import com.example.l_homework.R
import com.example.l_homework.data.AppDB
import com.example.l_homework.data.EtData
import kotlinx.android.synthetic.main.activity_data.*

class DataActivity : AppCompatActivity() {

    private var db : AppDB? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_data)
        setupListeners()
        db = MyApp.app?.getDB()
    }

    private fun setupListeners(){
        btn_save.setOnClickListener {
            db?.getEtDao()?.insertEtData(fetchData())
            startActivity(Intent(applicationContext, MainActivity ::class.java))
        }
    }

    private fun fetchData() : EtData{
        return EtData(
           etOne =  txt_title.text.toString(),
           etTwo =   txt_desc.text.toString()
        )
    }
}