package com.leonbec.coderswag.Adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.leonbec.coderswag.Model.Category
import com.leonbec.coderswag.R
import kotlinx.android.synthetic.main.category_list_item.view.*

/**
 * Created by leonbec on 2017/12/27.
 */
class CategoryAdapter(private val context: Context,
                      private val categories: List<Category>,
                      private val itemClick: (Category) -> Unit)
    : RecyclerView.Adapter<CategoryAdapter.VH>() {

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): VH {
        val view = LayoutInflater.from(context)
                .inflate(R.layout.category_list_item, parent, false)
        return VH(view, itemClick)
    }

    override fun onBindViewHolder(holder: VH?, position: Int) {
        holder?.bindCategory(categories[position], context)
    }

    override fun getItemCount(): Int {
        return categories.count()
    }

    class VH(itemView: View?, private val itemClick: (Category) -> Unit) : RecyclerView.ViewHolder(itemView) {
        private val categoryImage = itemView?.categoryImage
        private val categoryName = itemView?.categoryName
        fun bindCategory(category: Category, context: Context) {
            val resId = context.resources.getIdentifier(category.image, "drawable", context.packageName)
            categoryImage?.setImageResource(resId)
            categoryName?.text = category.title
            itemView.setOnClickListener { itemClick(category) }
        }
    }
}