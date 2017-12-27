package com.leonbec.coderswag.Controller

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.leonbec.coderswag.Adapter.CategoryAdaptor
import com.leonbec.coderswag.R
import com.leonbec.coderswag.Service.DataService
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var adapter: CategoryAdaptor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        adapter = CategoryAdaptor(this, DataService.categories)
        categoryRV.adapter = adapter

        val layoutManager = LinearLayoutManager(this)
        categoryRV.layoutManager = layoutManager
        categoryRV.setHasFixedSize(true)
    }
}
