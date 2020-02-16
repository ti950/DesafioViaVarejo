package com.pereira.tiago.desafioviavarejo.model

import com.pereira.tiago.desafioviavarejo.base.BaseService
import com.pereira.tiago.desafioviavarejo.base.RetrofitInitializer
import com.pereira.tiago.desafioviavarejo.domain.ResponseProducts
import com.pereira.tiago.desafioviavarejo.interfaces.ContractProduct
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class ProductModel(private val presenter: ContractProduct.ProductPresenter)
    : ContractProduct.ProductModel {

    private var mCompositeDisposable: CompositeDisposable = CompositeDisposable()

    override fun getProducts() {

        val retrofitInitializer = RetrofitInitializer().init().create(BaseService::class.java)

        mCompositeDisposable.add(retrofitInitializer.getProducts()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe(this::handleResponse, this::handleError))
    }

    private fun handleResponse(responseProducts: ResponseProducts) {
        presenter.setListProducts(responseProducts)
    }

    private fun handleError(error: Throwable) {
        presenter.errorLoad(error)
    }

}