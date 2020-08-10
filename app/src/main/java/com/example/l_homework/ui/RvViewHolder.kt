package com.example.l_homework.ui

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.l_homework.data.EtData
import kotlinx.android.synthetic.main.activity_data.view.*
import kotlinx.android.synthetic.main.grid_layout.view.*

class RvViewHolder(view: View)  : RecyclerView.ViewHolder(view){
    fun bind(etData: EtData) {
        itemView.tv_title.text = etData.etOne
        itemView.tv_desc.text = etData.etTwo
    }
}