package com.example.coffeetime.models

import android.content.Context
import android.view.Gravity
import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import android.widget.LinearLayout
import android.widget.TextView
import com.example.coffeetime.R
import java.io.Serializable

/**
 * Class for holding the different coffee types. Named "Product" to make the model
 * more flexible to future extensions (cake, smoothies etc)
 *
 * Future extension: handle different prize based on choices (size, strength etc)
 */
class Product (val name: String = "",
               val price: Float = 0F,
               val hasOptions: Boolean = false,
               val category: Category = Category.COFFEE) : Serializable {

    /**
     * Creates a LinearLayout which displays the product name and price
     */
    fun createView(context: Context): LinearLayout {
        val layout = LinearLayout(context)
        layout.orientation = LinearLayout.HORIZONTAL
        layout.setPadding(10, 10, 0, 20)
        layout.layoutParams = LinearLayout.LayoutParams(MATCH_PARENT, MATCH_PARENT, 0.6F)
        layout.addView(createNameView(context))


        layout.addView(createPriceView(context))

        return layout
    }



    /**
     * Creates a TextView containing the product name
     */
    private fun createNameView(context: Context): TextView {
        val nameView = TextView(context)
        nameView.text = this.name
        nameView.textSize = 22f
        nameView.setTextColor(context.resources.getColor(R.color.black))
        nameView.layoutParams = LinearLayout.LayoutParams(MATCH_PARENT, MATCH_PARENT, 1F)
        return nameView
    }

    /**
     * Creates a TextView containing the price of the product
     */
    private fun createPriceView(context: Context): TextView {
        val priceView = TextView(context)
        if (this.price == 0F) {
            priceView.text = "-"
        } else {
            priceView.text = this.price.toString().plus(" ").plus(context.getString(R.string.currency))
        }
        priceView.textSize = 22f
        priceView.gravity = Gravity.CENTER
        priceView.layoutParams = LinearLayout.LayoutParams(MATCH_PARENT, MATCH_PARENT, 1F)
        return priceView
    }
}