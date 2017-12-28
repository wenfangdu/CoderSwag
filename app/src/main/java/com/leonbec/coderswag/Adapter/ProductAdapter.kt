package com.leonbec.coderswag.Adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.jonnyb.coderswag.Model.Product
import com.leonbec.coderswag.R
import kotlinx.android.synthetic.main.product_list_item.view.*

/**
 * Created by leonbec on 2017/12/28.
 */
class ProductAdapter(val context: Context, val products: List<Product>) : RecyclerView.Adapter<ProductAdapter.VH>() {
    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): VH {
        val view = LayoutInflater.from(context)
                .inflate(R.layout.product_list_item, parent, false)
        return VH(view)
    }

    override fun onBindViewHolder(holder: VH?, position: Int) {
        holder?.bindProduct(context, products[position])
    }

    override fun getItemCount(): Int {
        return products.count()
    }

    inner class VH(view: View) : RecyclerView.ViewHolder(view) {
        val productImage = view.productImage
        val productName = view.productName
        val productPrice = view.productPrice

        fun bindProduct(context: Context, product: Product) {
            val resId = context.resources.getIdentifier(product.image, "drawable", context.packageName)
            productImage.setImageResource(resId)
            productName.text = product.title
            productPrice.text = product.price
        }
    }
}