package com.example.coffeetime.utilities

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.RadioButton
import android.widget.RadioGroup
import com.example.coffeetime.models.Category
import com.example.coffeetime.models.MenuItem
import com.example.coffeetime.models.ProductOption

class ProductOptionUtilities() {

    companion object {

        /**
         * Create radio buttons for each option in category if product has options
         * and add onChangeListener
         */
        fun createOptionsView(context: Context, menuItem: MenuItem): View {
            val radioGroup = RadioGroup(context)
            radioGroup.orientation = RadioGroup.HORIZONTAL
            radioGroup.layoutParams = LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT, 0.9F)

            when (menuItem.product.category) {
                Category.COFFEE -> {
                    if (menuItem.product.hasOptions) {
                        val options = ProductOption.values().filter { it.category == Category.COFFEE }.withIndex()
                        for ((rbId, option) in options) {
                            radioGroup.addView(createRadioButton(context, option.option, rbId))
                        }
                        radioGroup.setOnCheckedChangeListener { _, checkedId ->
                            menuItem.isChosen = true
                            menuItem.option = options.elementAt(checkedId).value
                        }
                    } else {
                        radioGroup.addView(createRadioButton(context, ProductOption.REGULAR.option, 0))
                        radioGroup.setOnCheckedChangeListener { _, _ ->
                            menuItem.isChosen = true
                            menuItem.option = ProductOption.REGULAR
                        }
                    }
                }
                // TODO: Future extension: add other product categories e.g cake, smoothie
            }
            return radioGroup
        }

        /**
         * Creates a radio button for the different product-options
         */
        private fun createRadioButton(context: Context, text: String, id: Int): RadioButton {
            val rb = RadioButton(context)
            rb.id = id
            rb.text = text
            return rb
        }
    }
}