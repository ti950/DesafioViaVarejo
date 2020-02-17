package com.pereira.tiago.desafioviavarejo.domain

import Opinioes
import com.google.gson.annotations.SerializedName

data class ResponseEvaluation(

    @SerializedName("classificacao") val classificacao : Double,
    @SerializedName("quantidade") val quantidade : Int,
    @SerializedName("opinioes") val opinioes : List<Opinioes>,
    var qtdText: String
)