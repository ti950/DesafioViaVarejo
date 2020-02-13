package com.pereira.tiago.desafioviavarejo

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import com.pereira.tiago.desafioviavarejo.ui.products.ProductsFragment
import com.pereira.tiago.desafioviavarejo.ui.home.HomeFragment
import com.pereira.tiago.desafioviavarejo.util.replaceFragment

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    lateinit var toolbar: Toolbar
    lateinit var drawerLayout: DrawerLayout
    lateinit var navView: NavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        drawerLayout = findViewById(R.id.drawer_layout)
        navView = findViewById(R.id.nav_view)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.

        val toggle = ActionBarDrawerToggle(
            this, drawerLayout, toolbar, 0, 0
        )
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
        navView.setNavigationItemSelectedListener(this)
    }

    override fun onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.nav_home -> {
                replaceFragment(
                    fragment = HomeFragment(),
                    allowStateLoss = true,
                    containerViewId = R.id.nav_host_fragment)
                title = resources.getString(R.string.menu_home)
            }
            R.id.nav_products -> {
                replaceFragment(
                    fragment = ProductsFragment(),
                    allowStateLoss = true,
                    containerViewId = R.id.nav_host_fragment)
                title = resources.getString(R.string.menu_products)
            }
        }
        drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }
}
