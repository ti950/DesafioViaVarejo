package com.pereira.tiago.desafioviavarejo.interfaces

import Valores
import android.content.Context
import com.pereira.tiago.desafioviavarejo.domain.ResponseDetails
import com.pereira.tiago.desafioviavarejo.domain.ResponseEvaluation
import com.pereira.tiago.desafioviavarejo.domain.ResponseSeeBuy
import com.pereira.tiago.desafioviavarejo.util.Connection

interface ContractDetails {

    interface DetailsModel {
        fun getMainDetails()
        fun getEvaluation()
        fun getSeeBuy()
    }

    interface DetailsPresenter {
        fun setConnection(connection: Connection)
        fun setContext(context: Context)
        fun setView(view: DetailsView)
        fun loadDetails()
        fun dataDetails(responseDetails: ResponseDetails)
        fun dataEvaluation(responseEvaluation: ResponseEvaluation)
        fun dataSeeBuy(responseSeeBuy: List<ResponseSeeBuy>)
        fun showError(error: Throwable)
    }

    interface DetailsView {
        fun showMainDetails(responseDetails: ResponseDetails)
        fun showCharacteristics(values: List<Valores>)
        fun showError()
        fun showEvaluation(responseEvaluation: ResponseEvaluation)
        fun showSeeBuy(responseSeeBuy: List<ResponseSeeBuy>)
        fun hideLoading()
        fun showLoading()
    }
}