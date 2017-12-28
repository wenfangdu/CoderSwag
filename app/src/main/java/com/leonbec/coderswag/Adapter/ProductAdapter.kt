package com.leonbec.coderswag.Adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.leonbec.coderswag.Model.Product
import com.leonbec.coderswag.R
import kotlinx.android.synthetic.main.product_list_item.view.*

/**
 * Created by leonbec on 2017/12/28.
 */
class ProductAdapter(private val context: Context,
                     private val products: List<Product>,
                     private val itemClick: (Product) -> Unit)
    : RecyclerView.Adapter<ProductAdapter.VH>() {

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): VH {
        val view = LayoutInflater.from(context)
                .inflate(R.layout.product_list_item, parent, false)
        return VH(view, itemClick)
    }

    override fun onBindViewHolder(holder: VH?, position: Int) {
        holder?.bindProduct(context, products[position])
    }

    override fun getItemCount(): Int {
        return products.count()
    }

    class VH(itemView: View?, private val itemClick: (Product) -> Unit) : RecyclerView.ViewHolder(itemView) {
        private val productImage = itemView?.productImage
        private val productName = itemView?.productName
        private val productPrice = itemView?.productPrice

        fun bindProduct(context: Context, product: Product) {
            val resId = context.resources.getIdentifier(product.image, "drawable", context.packageName)
            productImage?.setImageResource(resId)
            productName?.text = product.name
            productPrice?.text = product.price
            itemView.setOnClickListener { itemClick(product) }
        }
    }
}