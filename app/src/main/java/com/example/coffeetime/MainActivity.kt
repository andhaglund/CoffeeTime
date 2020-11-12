package com.example.coffeetime

import android.content.Intent
import android.os.Bundle
import android.view.View
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.coffeetime.utilities.FirestoreHandler
import com.example.coffeetime.utilities.OrderUtilities
import kotlinx.android.synthetic.main.fragment_order.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navView: BottomNavigationView = findViewById(R.id.nav_view)

        val navController = findNavController(R.id.nav_host_fragment)

        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(setOf(
                R.id.navigation_order, R.id.navigation_home, R.id.navigation_notifications))
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

        layout_order.addView(OrderUtilities.createOrderHeader(this))
        FirestoreHandler.getOrderLines(this, layout_order)
    }

    fun openOrderLineActivity(view: View) {
        val intent = Intent(this, OrderLineActivity::class.java)
        startActivity(intent)
    }
}