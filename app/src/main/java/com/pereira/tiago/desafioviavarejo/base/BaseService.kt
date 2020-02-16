package com.pereira.tiago.desafioviavarejo.base

import com.pereira.tiago.desafioviavarejo.domain.ResponseDetails
import com.pereira.tiago.desafioviavarejo.domain.ResponseEvaluation
import com.pereira.tiago.desafioviavarejo.domain.ResponseProducts
import com.pereira.tiago.desafioviavarejo.domain.ResponseSeeBuy
import retrofit2.http.POST
import io.reactivex.Observable

interface BaseService {

    @POST("5d1b4f0f34000074000006dd")
    fun getProducts() : Observable<ResponseProducts>

    @POST("5d1b4fd23400004c000006e1")
    fun getDetailsProduct(): Observable<ResponseDetails>

    @POST("5d1b4f9134000078000006e0")
    fun getEvaluation(): Observable<ResponseEvaluation>

    @POST("5d1b507634000054000006ed")
    fun getSeeBuy(): Observable<List<ResponseSeeBuy>>
}