package com.pereira.tiago.desafioviavarejo.domain

import com.google.gson.annotations.SerializedName

class ResponseSeeBuy (
    @SerializedName("id") val id : Int,
    @SerializedName("sku") val sku : Int,
    @SerializedName("nome") val nome : String,
    @SerializedName("imagemUrl") val imagemUrl : String,
    @SerializedName("precoAtual") val precoAtual : Double,
    @SerializedName("precoAnterior") val precoAnterior : Double,
    @SerializedName("percentualCompra") val percentualCompra : Int,
    @SerializedName("classificacao") val classificacao : Double,
    @SerializedName("parcelamento") val parcelamento : String
)