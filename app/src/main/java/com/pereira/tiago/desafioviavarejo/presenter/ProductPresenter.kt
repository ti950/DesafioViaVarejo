package com.pereira.tiago.desafioviavarejo.presenter

import android.content.Context
import com.pereira.tiago.desafioviavarejo.domain.ResponseProducts
import com.pereira.tiago.desafioviavarejo.interfaces.ContractProduct
import com.pereira.tiago.desafioviavarejo.model.ProductModel
import com.pereira.tiago.desafioviavarejo.util.Connection

class ProductPresenter : ContractProduct.ProductPresenter {

    private val model: ContractProduct.ProductModel = ProductModel(this)
    private var view: ContractProduct.ProductView? = null
    private val connection: Connection = Connection()

    override fun setView(view: ContractProduct.ProductView) {
        this.view = view
    }

    override fun getListProducts(context: Context) {
        if (connection.haveNetworkConnection(context = context)) {
            view?.showLoading()
            model.getProducts()
        } else {
            view?.hideLoading()
            view?.showNoResults()
        }
    }

    override fun setListProducts(responseProducts: ResponseProducts) {
        view?.hideLoading()
        view?.showResults(responseProducts)
    }

    override fun errorLoad(error: Throwable) {
        view?.hideLoading()
        view?.showNoResults()
    }

}