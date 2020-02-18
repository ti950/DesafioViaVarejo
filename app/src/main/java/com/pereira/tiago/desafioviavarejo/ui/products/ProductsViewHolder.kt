package com.pereira.tiago.desafioviavarejo.ui.products

import Produtos
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.pereira.tiago.desafioviavarejo.R
import com.pereira.tiago.desafioviavarejo.util.NumberFormatUtil
import kotlinx.android.synthetic.main.item_product.view.*

class ProductsViewHolder (view: View) : RecyclerView.ViewHolder(view) {
    fun bind(products: Produtos, listener: ProductsAdapter.Listener, height: Boolean) {

        val numberFormatUtil = NumberFormatUtil()

        Glide
            .with(itemView)
            .load(products.imagemUrl)
            .centerCrop()
            .into(itemView.imgProduct)


        itemView.txtNameProduct.text = products.nome
        itemView.txtOldPrice.text = numberFormatUtil.formateValue(products.preco.precoAnterior)
        itemView.txtCurrentPrice.text = numberFormatUtil.formateValue(products.preco.precoAtual.toDouble())

        if (height){
            itemView.viewHeight.visibility = View.VISIBLE
        } else {
            itemView.viewHeight.visibility = View.GONE
        }

        itemView.setOnClickListener {
            listener.onItemClick(products)
        }
    }
}