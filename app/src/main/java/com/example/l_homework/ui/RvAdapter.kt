package com.example.l_homework.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.l_homework.R
import com.example.l_homework.data.EtData

class RvAdapter : RecyclerView.Adapter<RvViewHolder>() {
    private  var data = arrayListOf<EtData>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RvViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.grid_layout, parent, false)
        return RvViewHolder(view)
    }
    fun update( data : List<EtData>){

        this.data.clear()
        this.data.addAll(data)
        notifyDataSetChanged()
    }

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: RvViewHolder, position: Int) {
        holder.bind(data[position])
    }
}