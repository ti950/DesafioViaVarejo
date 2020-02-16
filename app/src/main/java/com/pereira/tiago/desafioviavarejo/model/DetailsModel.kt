package com.pereira.tiago.desafioviavarejo.model

import com.pereira.tiago.desafioviavarejo.base.BaseService
import com.pereira.tiago.desafioviavarejo.base.RetrofitInitializer
import com.pereira.tiago.desafioviavarejo.domain.ResponseDetails
import com.pereira.tiago.desafioviavarejo.domain.ResponseEvaluation
import com.pereira.tiago.desafioviavarejo.domain.ResponseSeeBuy
import com.pereira.tiago.desafioviavarejo.interfaces.ContractDetails
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class DetailsModel(private val presenter: ContractDetails.DetailsPresenter)
    : ContractDetails.DetailsModel {

    private var mCompositeDisposable: CompositeDisposable = CompositeDisposable()
    private var mCompositeDisposableEvaluation: CompositeDisposable = CompositeDisposable()
    private var mCompositeDisposableSeeBuy: CompositeDisposable = CompositeDisposable()

    override fun getMainDetails() {
        val retrofitInitializer = RetrofitInitializer().init().create(BaseService::class.java)

        mCompositeDisposable.add(retrofitInitializer.getDetailsProduct()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe(this::handleResponse, this::handleError))
    }

    private fun handleResponse(responseDetails: ResponseDetails) {
        presenter.dataDetails(responseDetails = responseDetails)
    }

    private fun handleError(error: Throwable) {
        presenter.showError(error)
    }

    override fun getEvaluation() {
        val retrofitInitializer = RetrofitInitializer().init().create(BaseService::class.java)

        mCompositeDisposableEvaluation.add(retrofitInitializer.getEvaluation()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe(this::handleResponseEvaluation, this::handleError))
    }

    private fun handleResponseEvaluation(responseDetailsEvaluation: ResponseEvaluation) {
        presenter.dataEvaluation(responseEvaluation = responseDetailsEvaluation)
    }

    override fun getSeeBuy() {
        val retrofitInitializer = RetrofitInitializer().init().create(BaseService::class.java)

        mCompositeDisposableSeeBuy.add(retrofitInitializer.getSeeBuy()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe(this::handleResponseSee, this::handleError))
    }

    private fun handleResponseSee(responseSeeBuy: List<ResponseSeeBuy>) {
        presenter.dataSeeBuy(responseSeeBuy = responseSeeBuy)
    }
}