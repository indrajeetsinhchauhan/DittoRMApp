package com.indrajeet.chauhan.dittormapp.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.indrajeet.chauhan.dittormapp.R

class TabLayoutRecyclerViewAdapter(
    private val categories: List<String>,
    private val onTabClick: (Int) -> Unit
) : RecyclerView.Adapter<TabLayoutRecyclerViewAdapter.TabViewHolder>() {

    inner class TabViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textView: TextView = itemView.findViewById(R.id.tabTextView)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): TabLayoutRecyclerViewAdapter.TabViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_tab, parent, false)
        return TabViewHolder(view)
    }

    override fun onBindViewHolder(
        holder: TabLayoutRecyclerViewAdapter.TabViewHolder,
        position: Int
    ) {
        val category = categories[position % categories.size]
        holder.textView.text = category
        holder.itemView.setOnClickListener {
            if (it.isSelected)
                it.setBackgroundColor(it.context.resources.getColor(R.color.teal_200))
            else
                it.setBackgroundColor(it.context.resources.getColor(R.color.white))
            onTabClick(position % categories.size)
        }
    }

    override fun getItemCount(): Int {
        return categories.size
    }

}