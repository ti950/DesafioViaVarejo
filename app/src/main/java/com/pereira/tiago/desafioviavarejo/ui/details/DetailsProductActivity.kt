package com.pereira.tiago.desafioviavarejo.ui.details

import Valores
import android.content.Context
import android.content.Intent
import android.opengl.Visibility
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.pereira.tiago.desafioviavarejo.R
import com.pereira.tiago.desafioviavarejo.domain.ResponseDetails
import com.pereira.tiago.desafioviavarejo.domain.ResponseEvaluation
import com.pereira.tiago.desafioviavarejo.domain.ResponseSeeBuy
import com.pereira.tiago.desafioviavarejo.interfaces.ContractDetails
import com.pereira.tiago.desafioviavarejo.presenter.DetailsPresenter
import kotlinx.android.synthetic.main.activity_details_product.*

class DetailsProductActivity : AppCompatActivity(), ContractDetails.DetailsView {

    companion object {

        fun newInstance(context: Context): Intent {
            return Intent(context, DetailsProductActivity::class.java)
        }
    }

    private var presenter: ContractDetails.DetailsPresenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details_product)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)

        if(presenter == null){
            presenter = DetailsPresenter()
        }
        presenter!!.setView(this)
        presenter!!.loadDetails()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            finish()
        }
        return super.onOptionsItemSelected(item)
    }

    override fun showMainDetails(responseDetails: ResponseDetails) {
        Glide
            .with(this)
            .load(responseDetails.modelo.padrao.imagens[0].url)
            .centerCrop()
            .into(imgBig)

        supportActionBar?.title = responseDetails.nome

        txtNameProduct.text = responseDetails.nome
        txtDescriptionProduct.text = responseDetails.descricao
        txtOldPrice.text = responseDetails.modelo.padrao.preco.precoAnteriorText
        txtCurrentPrice.text = responseDetails.modelo.padrao.preco.precoAtualText
        txtInstallment.text = responseDetails.modelo.padrao.preco.planoPagamento
    }

    override fun showCharacteristics(values: List<Valores>) {
        val mAdapter: DetailsAdapter? = DetailsAdapter(values)
        rcvCharacteristics.setHasFixedSize(true)
        val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(this)
        rcvCharacteristics.layoutManager = layoutManager
        rcvCharacteristics.adapter = mAdapter
    }

    override fun showError() {
        pbLoad.visibility = View.GONE
        clMain.visibility = View.GONE
        txtNoResults.visibility = View.VISIBLE
    }

    override fun showEvaluation(responseEvaluation: ResponseEvaluation) {
        txtRattingEvaluation.text = responseEvaluation.classificacao.toString()
        txtCountEvaluation.text = responseEvaluation.qtdText
        txtNameComment.text = responseEvaluation.opinioes[0].cliente
        txtDescComment.text = responseEvaluation.opinioes[0].comentario
    }

    override fun showSeeBuy(responseSeeBuy: List<ResponseSeeBuy>) {
        val mAdapterSee = SeeAdapter(responseSeeBuy)

        rcvMoreProducts.setHasFixedSize(true)
        val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(
            this,
            LinearLayoutManager.HORIZONTAL,
            false
        )
        rcvMoreProducts.layoutManager = layoutManager
        rcvMoreProducts.adapter = mAdapterSee
    }

    override fun hideLoading() {
        pbLoad.visibility = View.GONE
        clMain.visibility = View.VISIBLE
        txtNoResults.visibility = View.GONE
    }

    override fun showLoading() {
        pbLoad.visibility = View.VISIBLE
        clMain.visibility = View.GONE
        txtNoResults.visibility = View.GONE
    }
}