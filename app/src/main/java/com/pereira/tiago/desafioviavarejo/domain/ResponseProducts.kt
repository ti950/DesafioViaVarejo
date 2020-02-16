package com.pereira.tiago.desafioviavarejo.domain

import Produtos
import com.google.gson.annotations.SerializedName

data class ResponseProducts(
    @SerializedName("produtos") val produtos : List<Produtos>,
    @SerializedName("quantidade") val quantidade : Int
)