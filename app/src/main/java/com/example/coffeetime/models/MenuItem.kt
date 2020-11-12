package com.example.coffeetime.models

import android.content.Context
import android.widget.LinearLayout
import com.example.coffeetime.utilities.ProductOptionUtilities

class MenuItem(val product: Product) {
    var isChosen = false
    var option = ProductOption.REGULAR

    fun createMenuItemView(context: Context): LinearLayout {
        val layout = LinearLayout(context)
        layout.orientation = LinearLayout.HORIZONTAL
        layout.setPadding(10, 10, 10, 20)
        layout.addView(this.product.createProductView(context))
        layout.addView(ProductOptionUtilities.createOptionsView(context, this))
        return layout
    }
}