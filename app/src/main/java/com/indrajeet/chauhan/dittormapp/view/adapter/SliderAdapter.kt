package com.indrajeet.chauhan.dittormapp.view.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.indrajeet.chauhan.dittormapp.R

class SliderAdapter : RecyclerView.Adapter<SliderAdapter.SliderViewHolder>() {
    class SliderViewHolder(view: View) : RecyclerView.ViewHolder(view) {
//        private val imageView = view.findViewById<ImageView>(R.id.slider_image)
    }

    class DiffCallback : DiffUtil.ItemCallback<ImageView>() {
        override fun areItemsTheSame(oldItem: ImageView, newItem: ImageView): Boolean {
            return oldItem == newItem
        }
        @SuppressLint("DiffUtilEquals")
        override fun areContentsTheSame(oldItem: ImageView, newItem: ImageView): Boolean {
            return oldItem == newItem
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SliderViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_slider, parent,false)
        return SliderViewHolder(view)
    }

    override fun getItemCount(): Int {
        return 3
    }

    override fun onBindViewHolder(holder: SliderViewHolder, position: Int) {
        // Bind data to your views here
        // Since we're using a placeholder, no data binding is necessary for now
    }
}