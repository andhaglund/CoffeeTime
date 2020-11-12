package com.example.coffeetime.models

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import com.example.coffeetime.R
import java.io.Serializable
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter


class OrderLine(val product: Product = Product(),
                val option: ProductOption = ProductOption.REGULAR,
                val owner: User = User(),
                val price: Float = 0F,
                val comment: String = "",
                val date: String = LocalDateTime.now().format(DateTimeFormatter.ISO_DATE)) : Serializable {

    /**
     * Creates a LinearLayout containing orderLine information like
     * product, price, option and owner
     */
    fun createView(context: Context): View {
        val layout = LinearLayout(context)
        layout.orientation = LinearLayout.HORIZONTAL
        layout.setPadding(10, 10, 0, 20)
        layout.layoutParams = LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT, 1F)

        layout.addView(createTextView(context, this.product.name, R.color.black))

        // Show comment if product is other
        if (this.option == ProductOption.OTHER) {
            layout.addView(createTextView(context, this.comment, R.color.gray))
        } else {
            layout.addView(createTextView(context, this.option.option, R.color.gray))
        }

        // Show "-" if price is 0
        if (this.price == 0F) {
            layout.addView(createTextView(context, "-", R.color.gray))
        } else {
            layout.addView(createTextView(context, this.price.toString(), R.color.gray))
        }

        layout.addView(createTextView(context, "${this.owner.firstName} ${this.owner.lastName}",
            R.color.black))

        return layout
    }

    /**
     * Creates a TextView containing the product name
     */
    private fun createTextView(context: Context, text: String, colorId: Int): TextView {
        val tv = TextView(context)
        tv.text = text
        tv.textSize = 18f
        tv.setTextColor(context.resources.getColor(colorId))
        tv.layoutParams = LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.MATCH_PARENT, 1F)
        return tv
    }
}