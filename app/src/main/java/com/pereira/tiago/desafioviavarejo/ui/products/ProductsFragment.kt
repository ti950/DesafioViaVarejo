package com.pereira.tiago.desafioviavarejo.ui.products

import Produtos
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.pereira.tiago.desafioviavarejo.R
import com.pereira.tiago.desafioviavarejo.domain.ResponseProducts
import com.pereira.tiago.desafioviavarejo.interfaces.ContractProduct
import com.pereira.tiago.desafioviavarejo.presenter.ProductPresenter
import com.pereira.tiago.desafioviavarejo.ui.details.DetailsProductActivity
import kotlinx.android.synthetic.main.fragment_products.*


class ProductsFragment : Fragment(), ProductsAdapter.Listener, ContractProduct.ProductView {

    private var mProductList: ArrayList<Produtos>? = null

    private var mAdapter: ProductsAdapter? = null

    private var presenter: ContractProduct.ProductPresenter? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_products, container, false)

        if (presenter == null){
            presenter = ProductPresenter()
        }
        presenter!!.setView(this)
        presenter!!.getListProducts()

        return view
    }

    private fun initRecyclerView() {

        rcvProducts.setHasFixedSize(true)

        val layoutManager : RecyclerView.LayoutManager = GridLayoutManager(activity, 2)
        rcvProducts!!.layoutManager = layoutManager
        rcvProducts!!.addItemDecoration(DividerItemDecoration(
            context!!,
            16,
            16
        ))
    }

    override fun onItemClick(products: Produtos) {
        startActivity(DetailsProductActivity.newInstance(context!!))
    }

    override fun showNoResults() {
        rcvProducts!!.visibility = View.VISIBLE
        txtNoResults.visibility = View.GONE
    }

    override fun showResults(responseProducts: ResponseProducts) {
        mProductList = ArrayList(responseProducts.produtos)
        mAdapter = ProductsAdapter(mProductList!!, this)
        rcvProducts!!.adapter = mAdapter
        rcvProducts!!.visibility = View.VISIBLE
        txtNoResults.visibility = View.GONE

        initRecyclerView()
    }
}