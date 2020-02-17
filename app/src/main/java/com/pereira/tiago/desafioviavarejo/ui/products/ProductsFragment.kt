package com.pereira.tiago.desafioviavarejo.ui.products

import Produtos
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.pereira.tiago.desafioviavarejo.R
import com.pereira.tiago.desafioviavarejo.domain.ResponseProducts
import com.pereira.tiago.desafioviavarejo.interfaces.ContractProduct
import com.pereira.tiago.desafioviavarejo.presenter.ProductPresenter
import com.pereira.tiago.desafioviavarejo.ui.details.DetailsProductActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DividerItemDecoration


class ProductsFragment : Fragment(), ProductsAdapter.Listener, ContractProduct.ProductView {

    private var mProductList: ArrayList<Produtos>? = null

    private var mAdapter: ProductsAdapter? = null

    private var presenter: ContractProduct.ProductPresenter? = null

    private lateinit var pbLoad: ProgressBar

    private lateinit var rcvProducts: RecyclerView

    private lateinit var txtNoResults: TextView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_products, container, false)

        pbLoad = view.findViewById(R.id.pbLoad)
        rcvProducts = view.findViewById(R.id.rcvProducts)
        txtNoResults = view.findViewById(R.id.txtNoResults)

        if (presenter == null){
            presenter = ProductPresenter()
        }
        presenter!!.setView(this)
        presenter!!.getListProducts(context!!)

        return view
    }

    private fun initRecyclerView() {

        rcvProducts.setHasFixedSize(true)

        val layoutManager : RecyclerView.LayoutManager = GridLayoutManager(activity, 2)
        rcvProducts.layoutManager = layoutManager

        val horizontalDecoration = DividerItemDecoration(
            rcvProducts.context,
            DividerItemDecoration.VERTICAL
        )
        val horizontalDivider = ContextCompat.getDrawable(activity!!, R.drawable.horizontal_divider)
        if (horizontalDivider != null) {
            horizontalDecoration.setDrawable(horizontalDivider)
        }
        rcvProducts.addItemDecoration(horizontalDecoration)
    }

    override fun onItemClick(products: Produtos) {
        startActivity(DetailsProductActivity.newInstance(context!!))
    }

    override fun showNoResults() {
        rcvProducts.visibility = View.GONE
        txtNoResults.visibility = View.VISIBLE
    }

    override fun showResults(responseProducts: ResponseProducts) {
        mProductList = ArrayList(responseProducts.produtos)
        mAdapter = ProductsAdapter(mProductList!!, this)
        rcvProducts.adapter = mAdapter
        rcvProducts.visibility = View.VISIBLE
        txtNoResults.visibility = View.GONE

        initRecyclerView()
    }

    override fun hideLoading() {
        pbLoad.visibility = View.GONE
    }

    override fun showLoading() {
        pbLoad.visibility = View.VISIBLE
        rcvProducts.visibility = View.GONE
        txtNoResults.visibility = View.GONE
    }
}