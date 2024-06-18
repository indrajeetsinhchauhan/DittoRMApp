package com.indrajeet.chauhan.dittormapp.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.indrajeet.chauhan.dittormapp.R

class MyAdapter: RecyclerView.Adapter<MyAdapter.MyViewHolder>() {
    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_recyclerview, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        // Bind data to your views here
        // Since we're using a placeholder, no data binding is necessary for now
    }

    override fun getItemCount(): Int {
        return 10 // Adjust based on your data
    }
}