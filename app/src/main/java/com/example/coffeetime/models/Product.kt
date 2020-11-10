package com.example.coffeetime.models

import android.content.Context
import android.icu.number.Precision.currency
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import android.widget.LinearLayout
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import com.example.coffeetime.R
import org.w3c.dom.Text
import java.io.Serializable

/**
 * Class for holding the different coffee types. Named "Product" to make the model
 * more flexible to future extensions (cake, smoothies etc)
 *
 * Future extension: handle different prize based on choices (size, strength etc)
 */
class Product (val name: String,
               val price: Float,
               val hasOptions: Boolean,
               val category: Category = Category.COFFEE) : Serializable {

    fun createProductView(context: Context): LinearLayout {
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
        priceView.text = this.price.toString().plus(" ").plus(context.getString(R.string.currency))
        priceView.textSize = 22f
        priceView.gravity = Gravity.CENTER
        priceView.layoutParams = LinearLayout.LayoutParams(MATCH_PARENT, MATCH_PARENT, 1F)
        return priceView
    }
}