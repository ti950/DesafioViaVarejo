package com.pereira.tiago.desafioviavarejo.util

import java.text.NumberFormat

open class NumberFormatUtil {

    fun formateValue(preco: Double): String {
        return NumberFormat.getCurrencyInstance().format(preco)
    }
}