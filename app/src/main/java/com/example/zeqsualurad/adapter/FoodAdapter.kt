package com.example.zeqsualurad.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.zeqsualurad.R
import com.example.zeqsualurad.model.Food
import java.security.AccessControlContext

class FoodAdapter(val context: Context, private val foods: ArrayList<Food>, private val listener: OnItemClickListener):
    RecyclerView.Adapter<FoodAdapter.ViewHolder>() {

    inner class ViewHolder(view: View): RecyclerView.ViewHolder(view), View.OnClickListener {
        val title: TextView = view.findViewById(R.id.title)
        val description: TextView = view.findViewById(R.id.description)
        val imageView: ImageView = view.findViewById(R.id.imageView)

        val item: RelativeLayout = view.findViewById(R.id.itemFood)

        init {
            item.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            val position = adapterPosition
            if (position != RecyclerView.NO_POSITION) {
                listener.onItemClick(position)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_food, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = foods[position]
        holder.title.text = currentItem.title
        holder.description.text = currentItem.description

        Glide.with(context)
            .load(currentItem.imageUrl)
            .into(holder.imageView)
    }

    override fun getItemCount() = foods.size

    interface OnItemClickListener {
        fun onItemClick(position: Int)
    }

}












