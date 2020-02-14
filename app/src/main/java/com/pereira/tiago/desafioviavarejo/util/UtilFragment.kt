package com.pereira.tiago.desafioviavarejo.util

import androidx.annotation.IdRes
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

fun AppCompatActivity.replaceFragment(fragment: Fragment,
    allowStateLoss: Boolean = false, @IdRes containerViewId: Int) {
    val ft = supportFragmentManager.beginTransaction().replace(containerViewId, fragment)
    //ft.addToBackStack(null)
    if(!supportFragmentManager.isStateSaved){
        ft.commit()
    } else if (allowStateLoss){
        ft.commitAllowingStateLoss()
    }
}