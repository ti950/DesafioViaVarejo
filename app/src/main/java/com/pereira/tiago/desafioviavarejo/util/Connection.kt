package com.pereira.tiago.desafioviavarejo.util

import android.content.Context
import android.net.ConnectivityManager

open class Connection {

    fun haveNetworkConnection(context: Context): Boolean {
        var haveConnectedWifi = false
        var haveConnectedMobile = false

        for (ni in (context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager).allNetworkInfo) {
            if (ni.typeName.equals("WIFI", ignoreCase = true) && ni.isConnected) {
                haveConnectedWifi = true
            }

            if (ni.typeName.equals("MOBILE", ignoreCase = true) && ni.isConnected) {
                haveConnectedMobile = true
            }
        }
        return haveConnectedWifi || haveConnectedMobile
    }
}