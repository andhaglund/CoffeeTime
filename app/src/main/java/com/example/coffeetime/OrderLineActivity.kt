package com.example.coffeetime

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import com.example.coffeetime.models.*
import com.example.coffeetime.utilities.DataHandler
import com.example.coffeetime.utilities.FirestoreHandler
import com.example.coffeetime.utilities.MenuItemUtilities
import com.example.coffeetime.utilities.ProductUtilities
import kotlinx.android.synthetic.main.activity_orderline.*

class OrderLineActivity : AppCompatActivity() {

    private lateinit var owner: User
    private lateinit var products: List<Product>
    private lateinit var menuItems: List<MenuItem>
    private val orderLines = mutableListOf<OrderLine>()
    private var comment: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_orderline)

        owner = DataHandler.getLocalUser(this)
        products = ProductUtilities.getProducts()
        menuItems = MenuItemUtilities.createMenuItems(products)

        orderline_layout.addView(MenuItemUtilities.createMenuItemAndHeaderViews(this, menuItems))
        orderline_layout.addView(createCommentView(this))
        orderline_layout.addView(createSubmitButton())
    }

    /**
     * Creates submit button with onClickListener which creates one orderLine
     * pr chosen product and sends it back to the order-page.
     */
    private fun createSubmitButton(): Button {
        val button = Button(this)
        button.text = getString(R.string.submit)
        button.setOnClickListener {
            for ((index, menuItem) in menuItems.filter{it.isChosen}.withIndex()) {

                // If multiple orderLines , only add comment to the one with option OTHER
                if (menuItems.none { it.option == ProductOption.OTHER } && index == 0 ||
                        menuItem.option == ProductOption.OTHER) {
                    orderLines.add(OrderLine(menuItem.product, menuItem.option, owner,
                            menuItem.product.price + menuItem.option.additionalCost, comment))
                } else {
                    orderLines.add(OrderLine(menuItem.product, menuItem.option, owner,
                            menuItem.product.price + menuItem.option.additionalCost))
                }

            }


            val intent = Intent(this, MainActivity::class.java)
            for (orderLine in orderLines) {
                FirestoreHandler.addOrderLine(orderLine)
            }
            startActivity(intent)
        }
        return button
    }

    /**
     * Create comment text input view
     */
    private fun createCommentView(context: Context): View {
        val editText = EditText(context)
        editText.hint = context.getString(R.string.comment)
        editText.addTextChangedListener{
            comment = editText.text.toString()
        }
        return editText
    }
}