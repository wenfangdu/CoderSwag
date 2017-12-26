package com.leonbec.coderswag.Controller

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import com.example.jonnyb.coderswag.Model.Category
import com.leonbec.coderswag.Adapter.CategoryAdapter
import com.leonbec.coderswag.R
import com.leonbec.coderswag.Service.DataService
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var adapter: CategoryAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        adapter = CategoryAdapter(this,DataService.categories)

        categoryLV.adapter = adapter
    }
}
