package com.pereira.tiago.desafioviavarejo.ui.products

import Produtos
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.pereira.tiago.desafioviavarejo.R
import kotlinx.android.synthetic.main.item_product.view.*

class ProductsViewHolder (view: View) : RecyclerView.ViewHolder(view) {
    fun bind(products: Produtos, listener: ProductsAdapter.Listener) {

        Glide
            .with(itemView)
            .load(products.imagemUrl)
            .centerCrop()
            .into(itemView.imgProduct)


        itemView.txtNameProduct.text = products.nome
        itemView.txtOldPrice.text = "R$ ${products.preco.precoAnterior}"
        itemView.txtCurrentPrice.text = "R$ ${products.preco.precoAtual}"

        itemView.setOnClickListener {
            listener.onItemClick(products)
        }
    }
}