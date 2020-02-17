package com.pereira.tiago.desafioviavarejo.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.pereira.tiago.desafioviavarejo.BuildConfig
import com.pereira.tiago.desafioviavarejo.R

class HomeFragment : Fragment() {

    private lateinit var txtVersionCod: TextView
    private lateinit var txtVersion: TextView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val root = inflater.inflate(R.layout.fragment_home, container, false)

        txtVersionCod = root.findViewById(R.id.txtVersionCod)
        txtVersion = root.findViewById(R.id.txtVersion)

        init()

        return root
    }

    fun init() {
        txtVersion.text = resources.getString(R.string.app_version_name, BuildConfig.VERSION_NAME)
        txtVersionCod.text = resources.getString(R.string.app_version_code, BuildConfig.VERSION_CODE)
    }
}