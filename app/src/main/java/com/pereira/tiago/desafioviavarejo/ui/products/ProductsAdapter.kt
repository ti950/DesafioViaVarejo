package com.pereira.tiago.desafioviavarejo.ui.products

import Produtos
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.pereira.tiago.desafioviavarejo.R

class ProductsAdapter (
    private val dataList: ArrayList<Produtos>,
    private  val listener: Listener) : RecyclerView.Adapter<ProductsViewHolder>(){

    interface Listener {
        fun onItemClick(products: Produtos)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_product, parent, false)
        return ProductsViewHolder(view = view)
    }

    override fun getItemCount(): Int = dataList.count()

    override fun onBindViewHolder(holder: ProductsViewHolder, position: Int) {
        holder.bind(dataList[position], listener)
    }

}