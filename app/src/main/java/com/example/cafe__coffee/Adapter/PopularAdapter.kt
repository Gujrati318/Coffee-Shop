package com.example.cafe__coffee.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.bumptech.glide.Glide
import com.example.cafe__coffee.Domain.itemsModel
import com.example.cafe__coffee.databinding.ViewholderCategoryBinding
import com.example.cafe__coffee.databinding.ViewholderPopularBinding
import com.google.firebase.ai.type.Content

class PopularAdapter(val items: MutableList<itemsModel>):RecyclerView.Adapter<PopularAdapter.ViewHolder>() {
    lateinit var context:Context
    class ViewHolder(val binding: ViewholderPopularBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PopularAdapter.ViewHolder {
        context=parent.context
        val binding= ViewholderPopularBinding.inflate(LayoutInflater.from(context),parent,false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PopularAdapter.ViewHolder, position: Int) {
       holder.binding.titleTxT.text= items[position].title
        holder.binding.priceTxt.text= "$" + items[position].price.toString()

        Glide.with(context)
            .load(items[position].picUri[0])
            .into(holder.binding.pic)
    }

    override fun getItemCount(): Int =items.size


}