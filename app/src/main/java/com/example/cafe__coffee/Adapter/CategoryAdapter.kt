package com.example.cafe__coffee.Adapter

import android.content.Context
import android.content.Intent
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.cafe__coffee.Activity.ItemsListActivity
import com.example.cafe__coffee.Domain.CategoryModel
import com.example.cafe__coffee.R

import com.example.cafe__coffee.databinding.ViewholderCategoryBinding
  
class CategoryAdapter(val items: MutableList<CategoryModel>) :
    RecyclerView.Adapter<CategoryAdapter.Viewholder>() {
    private lateinit var context: Context
    private var selectedPosition = -1
    private var lastselectedPosition = -1

    inner class Viewholder(val binding: ViewholderCategoryBinding) :
        RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryAdapter.Viewholder {
        context = parent.context
        val binding = ViewholderCategoryBinding.inflate(LayoutInflater.from(context), parent, false)
        return Viewholder(binding)
    }

    override fun onBindViewHolder(holder: CategoryAdapter.Viewholder, position: Int) {
        val item = items[position]
        holder.binding.titleCat.text = item.title

        holder.binding.root.setOnClickListener {
            lastselectedPosition = selectedPosition
            selectedPosition = position
            notifyItemChanged(lastselectedPosition)
            notifyItemChanged(selectedPosition)


            Handler(Looper.getMainLooper()).postDelayed({
                val intent = Intent(context, ItemsListActivity::class.java).apply {
                    putExtra("id", item.id.toString())
                    putExtra("title", item.title)
                }
                ContextCompat.startActivity(context, intent, null)
            },500)
        }
        if (selectedPosition == position) {
            holder.binding.titleCat.setBackgroundResource(R.drawable.dark_brown)
            holder.binding.titleCat.setTextColor(context.resources.getColor(R.color.white))
        } else {
            holder.binding.titleCat.setBackgroundResource(R.drawable.white_bg)
            holder.binding.titleCat.setTextColor(context.resources.getColor(R.color.darkBrown))
        }
    }

    override fun getItemCount(): Int = items.size
}




