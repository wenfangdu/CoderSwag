package com.leonbec.coderswag.Controller

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.leonbec.coderswag.Model.Product
import com.leonbec.coderswag.Adapter.ProductAdapter
import com.leonbec.coderswag.R
import com.leonbec.coderswag.Utility.EXTRA_PRODUCT
import kotlinx.android.synthetic.main.activity_product_info.*

class ProductInfoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_info)

        val product = intent.getParcelableExtra<Product>(EXTRA_PRODUCT)
        val resId = this.resources.getIdentifier(product.image, "drawable", this.packageName)

        productImage.setImageResource(resId)
        productName.text = product.name
        productPrice.text = product.price
        productDesc.text = product.desc
    }
}
