package com.indrajeet.chauhan.dittormapp.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.indrajeet.chauhan.dittormapp.R

class FavoritesCategoryAdapter : RecyclerView.Adapter<FavoritesCategoryAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_favorite_categories, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // Bind data to your views here
        // Since we're using a placeholder, no data binding is necessary for now
    }

    override fun getItemCount(): Int {
        return 9
    }

}