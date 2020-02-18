package com.pereira.tiago.desafioviavarejo

import android.content.Context
import com.nhaarman.mockito_kotlin.spy
import com.pereira.tiago.desafioviavarejo.interfaces.ContractDetails
import com.pereira.tiago.desafioviavarejo.presenter.DetailsPresenter
import com.pereira.tiago.desafioviavarejo.ui.details.DetailsProductActivity
import com.pereira.tiago.desafioviavarejo.util.Connection
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class DetailsProductActivityTest {

    @Mock
    var context: Context? = null

    @Mock
    var connection: Connection? = null

    @Mock
    var view: ContractDetails.DetailsView? = null

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)

        context = Mockito.mock(Context::class.java)

        connection = Mockito.mock(Connection::class.java)

        view = Mockito.mock(DetailsProductActivity::class.java)
    }

    @Test
    fun loadDetailsTest() {

        val spy = spy<DetailsPresenter>()

        spy.setView(view!!)

        spy.setContext(context!!)

        spy.setConnection(connection!!)

        spy.loadDetails()

        Mockito.verify(spy, Mockito.times(1))?.loadDetails()
    }

}