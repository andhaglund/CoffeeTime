package com.example.coffeetime.models

import android.content.Context
import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import android.widget.LinearLayout
import android.widget.RadioGroup
import android.widget.TextView
import com.example.coffeetime.R
import org.w3c.dom.Text

/**
 * Class for holding the different coffee types. Named "Product" to make the model
 * more flexible to future extensions (cake, smoothies etc)
 *
 * Future extension: handle different prize based on choices (size, strength etc)
 */
class Product (val name: String,
               val price: Float,
               val hasOptions: Boolean,
               val category: Category = Category.COFFEE) {

    fun createProductView(context: Context): LinearLayout {
        val layout = LinearLayout(context)
        layout.orientation = LinearLayout.HORIZONTAL

        layout.addView(createNameView(context))
        layout.addView(createPriceView(context))
        layout.addView(createOptionsView(context))



        return layout
    }

    /**
     * Create radio buttons if product has options
     */
    private fun createOptionsView(context: Context): RadioGroup {
        if (this.hasOptions) {
            when (category) {
                Category.COFFEE -> {
                    val single = RadioGroup(context)
                }
                // TODO
            }
        }
        return RadioGroup(context)
    }

    /**
     * Creates a TextView containing the product name
     */
    private fun createNameView(context: Context): TextView {
        val nameView = TextView(context)
        nameView.text = this.name
        nameView.textSize = 25f
        nameView.setTextColor(context.resources.getColor(R.color.black))
        nameView.layoutParams = LinearLayout.LayoutParams(MATCH_PARENT, MATCH_PARENT, 1F)
        return nameView
    }

    /**
     * Creates a TextView containing the price of the product
     */
    private fun createPriceView(context: Context): TextView {
        val priceView = TextView(context)
        priceView.text = this.price.toString()
        priceView.textSize = 25f
        priceView.layoutParams = LinearLayout.LayoutParams(MATCH_PARENT, MATCH_PARENT, 1F)
        return priceView
    }

}