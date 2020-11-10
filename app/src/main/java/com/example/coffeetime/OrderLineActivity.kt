package com.example.coffeetime

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.coffeetime.models.*
import com.example.coffeetime.utilities.ProductUtilities
import kotlinx.android.synthetic.main.activity_orderline.*

class OrderLineActivity : AppCompatActivity() {

    private lateinit var owner: User
    private val products: List<Product> = ProductUtilities.getProducts()
    private val menuItems: List<MenuItem> = createMenuItems()
    private val orderLines = mutableListOf<OrderLine>()

    private fun createMenuItems(): List<MenuItem> {
        val menuItems = mutableListOf<MenuItem>()
        for (product in products) {
            menuItems.add(MenuItem(product))
        }
        return menuItems
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_orderline)

// TODO: Get user from localstorage        owner = intent.extras!!.getSerializable("user") as User

        createMenuItemView(orderline_layout)
        orderline_layout.addView(createSubmitButton())
    }

    private fun createSubmitButton(): Button {
        val button = Button(this)
        button.text = getString(R.string.submit)
        button.setOnClickListener {
            for (menuItem in menuItems.filter{it.isChosen}) {
                orderLines.add(OrderLine(menuItem.product, menuItem.option, "Temp",
                        menuItem.product.price + menuItem.option.additionalCost))
            }

            val intent = Intent(this, MainActivity::class.java)
            for ((index, orderLine) in orderLines.withIndex()) {
                intent.putExtra("orderLine$index", orderLine)
            }
            startActivity(intent)
        }

        return button
    }

    /**
     * Creates a menu item view inside the input layout
     */
    private fun createMenuItemView(layout: LinearLayout) {
        for (category in Category.values().filter { it != Category.ALL }) {
            layout.addView(createCategoryHeader(category))

            for (menuItem in menuItems.filter { it.product.category == category }) {
                layout.addView(menuItem.createMenuLineView(this))
            }
        }
    }

    /**
     * Create header for each product category
     */
    private fun createCategoryHeader(category: Category): TextView {
        val header = TextView(this)
        header.text = category.category
        header.textSize = 25f
        header.setPadding(10, 20, 10, 20)
        header.setTextColor(resources.getColor(R.color.black))
        return header
    }
}