package com.pereira.tiago.desafioviavarejo.ui.details

import Valores
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_characteristics.view.*

class DetailsViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    fun bind(valores: Valores) {

        itemView.txtNameCharacteristics.text = valores.nome
        itemView.txtDescCharacteristics.text = valores.valor
    }
}