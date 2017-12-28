package com.leonbec.coderswag.Controller

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.leonbec.coderswag.Adapter.CategoryAdapter
import com.leonbec.coderswag.R
import com.leonbec.coderswag.Service.DataService
import com.leonbec.coderswag.Utility.EXTRA_CATEGORY
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var adapter: CategoryAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        adapter = CategoryAdapter(this, DataService.categories) { category ->
            val productIntent = Intent(this, ProductActivity::class.java)
            productIntent.putExtra(EXTRA_CATEGORY,category.title)
            startActivity(productIntent)
        }
        categoryRV.adapter = adapter

        val layoutManager = LinearLayoutManager(this)
        categoryRV.layoutManager = layoutManager
        categoryRV.setHasFixedSize(true)
    }
}