package com.pereira.tiago.desafioviavarejo.presenter

import Valores
import android.content.Context
import com.pereira.tiago.desafioviavarejo.R
import com.pereira.tiago.desafioviavarejo.base.Config
import com.pereira.tiago.desafioviavarejo.domain.ResponseDetails
import com.pereira.tiago.desafioviavarejo.domain.ResponseEvaluation
import com.pereira.tiago.desafioviavarejo.domain.ResponseSeeBuy
import com.pereira.tiago.desafioviavarejo.interfaces.ContractDetails
import com.pereira.tiago.desafioviavarejo.model.DetailsModel
import com.pereira.tiago.desafioviavarejo.util.Connection
import com.pereira.tiago.desafioviavarejo.util.NumberFormatUtil
import java.util.*

class DetailsPresenter: ContractDetails.DetailsPresenter {

    private val model: ContractDetails.DetailsModel = DetailsModel(this)
    private var view: ContractDetails.DetailsView? = null
    private var connection: Connection = Connection()
    private var numberFormatUtil: NumberFormatUtil = NumberFormatUtil()

    override fun getContext(): Context = view as Context

    override fun setView(view: ContractDetails.DetailsView) {
        this.view = view
    }

    override fun loadDetails() {
        view?.showLoading()
        if (connection.haveNetworkConnection(getContext())) {
            model.getMainDetails()
            model.getEvaluation()
            model.getSeeBuy()
        } else {
            view?.hideLoading()
            view?.showError()
        }
    }

    override fun dataDetails(responseDetails: ResponseDetails) {

        responseDetails.modelo.padrao.preco.precoAnteriorText =
                numberFormatUtil.formateValue(responseDetails.modelo.padrao.preco.precoAnterior)
        responseDetails.modelo.padrao.preco.precoAtualText =
                numberFormatUtil.formateValue(responseDetails.modelo.padrao.preco.precoAtual.toDouble())

        view?.showMainDetails(responseDetails = responseDetails)

        var values: List<Valores>? = null
        responseDetails.maisInformacoes.forEach {
            if(it.descricao.toLowerCase(Locale.ROOT) == Config.CHARACTERISTICS){
                values = it.valores
            }
        }

        if (!values.isNullOrEmpty()){
            view?.showCharacteristics(values = values!!)
        }
    }

    override fun showError(error: Throwable) {
        view?.showError()
    }

    override fun dataEvaluation(responseEvaluation: ResponseEvaluation) {

        val count = if (responseEvaluation.quantidade == 1)
            getContext().resources.getString(R.string.evaluation)
        else
            getContext().resources.getString(R.string.evaluations)

        responseEvaluation.qtdText = "(${responseEvaluation.quantidade} $count)"

        view?.showEvaluation(responseEvaluation = responseEvaluation)
    }

    override fun dataSeeBuy(responseSeeBuy: List<ResponseSeeBuy>) {
        view?.showSeeBuy(responseSeeBuy = responseSeeBuy)
        view?.hideLoading()
    }
}