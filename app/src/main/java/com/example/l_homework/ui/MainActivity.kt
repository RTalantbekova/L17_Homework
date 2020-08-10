package com.example.l_homework.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.GridLayoutManager
import com.example.l_homework.MyApp
import com.example.l_homework.R
import com.example.l_homework.data.AppDB
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private var db : AppDB? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        db = MyApp.app?.getDB()
        setupRecyclerView()

    }

    private fun setupRecyclerView() {
        val manager = GridLayoutManager(applicationContext, 2)
        recyclerView.layoutManager = manager
        val adapter = RvAdapter()
        recyclerView.adapter = adapter

        val data = db?.getEtDao()?.getAllData()
        if (data!= null)
        adapter.update(data)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId){
            R.id.new_page -> {
                startActivity(Intent(applicationContext, DataActivity::class.java))
            }
        }
        return super.onOptionsItemSelected(item)
    }
}