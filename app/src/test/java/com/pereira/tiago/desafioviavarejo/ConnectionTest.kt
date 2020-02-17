package com.pereira.tiago.desafioviavarejo

import android.content.Context
import com.nhaarman.mockito_kotlin.spy
import com.pereira.tiago.desafioviavarejo.util.Connection
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.MockitoAnnotations
import org.mockito.Mockito.mock


class ConnectionTest {

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
    }

    @Test
    fun haveNetworkConnectionTest() {
        val ctx = mock(Context::class.java)

        val spy = spy<Connection>()

        val have = spy.haveNetworkConnection(context = ctx)

        Assert.assertTrue(have)
    }
}