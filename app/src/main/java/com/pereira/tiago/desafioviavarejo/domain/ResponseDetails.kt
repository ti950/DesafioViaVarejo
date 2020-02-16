package com.pereira.tiago.desafioviavarejo.domain

import Categorias
import MaisInformacoes
import Marca
import Modelo
import com.google.gson.annotations.SerializedName

data class ResponseDetails(
    @SerializedName("id") val id : Int,
    @SerializedName("nome") val nome : String,
    @SerializedName("descricao") val descricao : String,
    @SerializedName("retiraEmLoja") val retiraEmLoja : Boolean,
    @SerializedName("categorias") val categorias : List<Categorias>,
    @SerializedName("maisInformacoes") val maisInformacoes : List<MaisInformacoes>,
    @SerializedName("marca") val marca : Marca,
    @SerializedName("modelo") val modelo : Modelo,
    @SerializedName("urlVideo") val urlVideo : String
)