package com.pereira.tiago.desafioviavarejo.interfaces

import android.content.Context
import com.pereira.tiago.desafioviavarejo.domain.ResponseProducts

interface ContractProduct {
    interface ProductModel {
        fun getProducts()
    }

    interface ProductPresenter {
        fun setView(view: ProductView)
        fun getListProducts(context: Context)
        fun setListProducts(responseProducts: ResponseProducts)
        fun errorLoad(error: Throwable)
    }

    interface ProductView {
        fun showNoResults()
        fun showResults(responseProducts: ResponseProducts)
        fun showLoading()
        fun hideLoading()
    }
}