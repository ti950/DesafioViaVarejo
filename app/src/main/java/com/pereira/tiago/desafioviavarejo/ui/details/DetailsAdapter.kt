package com.pereira.tiago.desafioviavarejo.ui.details

import Valores
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.pereira.tiago.desafioviavarejo.R

class DetailsAdapter(private val dataList: List<Valores>) : RecyclerView.Adapter<DetailsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DetailsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_characteristics, parent, false)
        return DetailsViewHolder(view = view)
    }

    override fun getItemCount(): Int = dataList.count()

    override fun onBindViewHolder(holder: DetailsViewHolder, position: Int) {
        holder.bind(dataList[position])
    }
}