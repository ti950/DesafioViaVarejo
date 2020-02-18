package com.pereira.tiago.desafioviavarejo

import android.content.Context
import com.nhaarman.mockito_kotlin.spy
import com.pereira.tiago.desafioviavarejo.util.Connection
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import org.mockito.Mockito.mock


class ConnectionTest {

    @Mock
    var context: Context? = null

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)

        context = mock(Context::class.java)
    }

    @Test
    fun haveNetworkConnectionTest() {

        val spy = spy<Connection>()

        val have = spy.haveNetworkConnection(context = context!!)

        Assert.assertTrue(have)
    }
}