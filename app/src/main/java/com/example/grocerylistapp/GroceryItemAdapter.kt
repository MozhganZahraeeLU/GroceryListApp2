package com.example.grocerylistapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class GroceryItemAdapter(private val items: List<GroceryItem>) :
    RecyclerView.Adapter<GroceryItemAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nameTextView: TextView = itemView.findViewById(R.id.item_name)
        val categoryTextView: TextView = itemView.findViewById(R.id.item_category)
        val typeTextView: TextView = itemView.findViewById(R.id.item_type)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.grocery_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.nameTextView.text = item.name
        holder.categoryTextView.text = item.category
        holder.typeTextView.text = item.type
    }

    override fun getItemCount() = items.size
}
