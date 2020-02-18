package com.pereira.tiago.desafioviavarejo.ui.details

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.pereira.tiago.desafioviavarejo.domain.ResponseSeeBuy
import com.pereira.tiago.desafioviavarejo.util.NumberFormatUtil
import kotlinx.android.synthetic.main.item_product.view.*

class SeeViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    fun bind(responseSeeBuy: ResponseSeeBuy) {

        val numberFormatUtil = NumberFormatUtil()

        Glide
            .with(itemView)
            .load(responseSeeBuy.imagemUrl)
            .centerCrop()
            .into(itemView.imgProduct)

        itemView.txtNameProduct.text = responseSeeBuy.nome
        itemView.txtOldPrice.text = numberFormatUtil.formateValue(responseSeeBuy.precoAnterior)
        itemView.txtCurrentPrice.text = numberFormatUtil.formateValue(responseSeeBuy.precoAtual)
        itemView.viewHeight.visibility = View.GONE
    }
}