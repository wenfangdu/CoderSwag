package com.leonbec.coderswag.Controller

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import com.leonbec.coderswag.Adapter.ProductAdapter
import com.leonbec.coderswag.R
import com.leonbec.coderswag.Service.DataService
import com.leonbec.coderswag.Utility.EXTRA_CATEGORY
import com.leonbec.coderswag.Utility.EXTRA_PRODUCT
import kotlinx.android.synthetic.main.activity_product.*

class ProductActivity : AppCompatActivity() {
    private lateinit var adapter: ProductAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product)

        val categoryType = intent.getStringExtra(EXTRA_CATEGORY)
        adapter = ProductAdapter(this, DataService.getProducts(categoryType)) { product ->
            val intent = Intent(this, ProductInfoActivity::class.java)
            intent.putExtra(EXTRA_PRODUCT, product)
            startActivity(intent)
        }
        productRV.adapter = adapter

        var spanCount = 2
        if (resources.configuration.screenWidthDp > 650)
            spanCount = 3

        val layoutManager = GridLayoutManager(this, spanCount)
        productRV.layoutManager = layoutManager
    }
}
