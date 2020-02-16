package com.pereira.tiago.desafioviavarejo.ui.details

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.pereira.tiago.desafioviavarejo.domain.ResponseSeeBuy
import kotlinx.android.synthetic.main.item_product.view.*

class SeeViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    fun bind(responseSeeBuy: ResponseSeeBuy) {

        Glide
            .with(itemView)
            .load(responseSeeBuy.imagemUrl)
            .centerCrop()
            .into(itemView.imgProduct)

        itemView.txtNameProduct.text = responseSeeBuy.nome
        itemView.txtOldPrice.text = "R$ ${responseSeeBuy.precoAnterior}"
        itemView.txtCurrentPrice.text = "R$ ${responseSeeBuy.precoAtual}"
    }
}