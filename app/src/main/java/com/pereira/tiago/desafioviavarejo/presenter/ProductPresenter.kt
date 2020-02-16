package com.pereira.tiago.desafioviavarejo.presenter

import android.content.Context
import com.pereira.tiago.desafioviavarejo.domain.ResponseProducts
import com.pereira.tiago.desafioviavarejo.interfaces.ContractProduct
import com.pereira.tiago.desafioviavarejo.model.ProductModel

class ProductPresenter : ContractProduct.ProductPresenter {

    private val model: ContractProduct.ProductModel = ProductModel(this)
    private var view: ContractProduct.ProductView? = null

    override fun getContext(): Context = view as Context

    override fun setView(view: ContractProduct.ProductView) {
        this.view = view
    }

    override fun getListProducts() {
        model.getProducts()
    }

    override fun setListProducts(responseProducts: ResponseProducts) {
        view?.showResults(responseProducts)
    }

    override fun errorLoad(error: Throwable) {
        view?.showNoResults()
    }

}