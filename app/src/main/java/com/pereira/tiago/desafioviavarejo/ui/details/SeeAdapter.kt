package com.pereira.tiago.desafioviavarejo.ui.details

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.pereira.tiago.desafioviavarejo.R
import com.pereira.tiago.desafioviavarejo.domain.ResponseSeeBuy

class SeeAdapter(private val dataList: List<ResponseSeeBuy>) : RecyclerView.Adapter<SeeViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SeeViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_product, parent, false)
        return SeeViewHolder(view = view)
    }

    override fun getItemCount(): Int = dataList.count()

    override fun onBindViewHolder(holder: SeeViewHolder, position: Int) {
        holder.bind(dataList[position])
    }

}