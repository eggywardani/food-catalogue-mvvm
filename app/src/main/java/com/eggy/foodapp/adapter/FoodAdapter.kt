package com.eggy.foodapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.eggy.foodapp.R
import com.eggy.foodapp.model.ResultsItem


class FoodAdapter(val data: List<ResultsItem?>?, val itemClick:OnClickListener) :
    RecyclerView.Adapter<FoodAdapter.FoodViewHolder>() {
    class FoodViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val thumbImage = itemView.findViewById<ImageView>(R.id.thumb_food)
        val nameFood = itemView.findViewById<TextView>(R.id.nama_makanan)

        fun bind(item: ResultsItem) {
            nameFood.text = item.title
            Glide.with(itemView.context)
                .load(item.thumb)
                .into(thumbImage)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodViewHolder {
        return FoodViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_food, parent, false)
        )
    }

    override fun onBindViewHolder(holder: FoodViewHolder, position: Int) {
        holder.bind(data?.get(position)!!)
        holder.itemView.setOnClickListener {
            itemClick.detail(data[position])
        }

    }

    override fun getItemCount(): Int = data?.size ?: 0

    interface OnClickListener{
        fun detail(item: ResultsItem?)

    }
}