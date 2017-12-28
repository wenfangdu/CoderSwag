package com.leonbec.coderswag.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.leonbec.coderswag.Model.Category
import com.leonbec.coderswag.R
import kotlinx.android.synthetic.main.category_list_item.view.*

/**
 * Created by leonbec on 2017/12/26.
 */
class CategoryAdapterForLV(val context: Context, val categories: List<Category>) : BaseAdapter() {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val viewHolder: ViewHolder
        val categoryView: View

        if (convertView == null) {
            viewHolder = ViewHolder()
            categoryView = LayoutInflater.from(context).inflate(R.layout.category_list_item, null)
            viewHolder.categoryImage = categoryView.categoryImage
            viewHolder.categoryName = categoryView.categoryName
            categoryView.tag = viewHolder
//            println("test first time")
        } else {
            viewHolder = convertView.tag as ViewHolder
            categoryView = convertView
//            println("test recycle")
        }
        val category = categories[position]
        val resId = context.resources.getIdentifier(category.image, "drawable", context.packageName)

        viewHolder.categoryImage.setImageResource(resId)
        viewHolder.categoryName.text = category.title

        return categoryView
    }

    override fun getItem(position: Int): Any {
        return categories[position]
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getCount(): Int {
        return categories.count()
    }

    private class ViewHolder {
        lateinit var categoryImage: ImageView
        lateinit var categoryName: TextView
    }
}