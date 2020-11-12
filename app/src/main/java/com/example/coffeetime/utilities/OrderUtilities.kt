package com.example.coffeetime.utilities

import android.content.Context
import android.graphics.Typeface
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import com.example.coffeetime.R

/**
 * Class for handling order and orderLine functionality
 */
class OrderUtilities {

    companion object {

        /**
         * Creates the header line on the order page with headers Product, Option, Price and Person
         */
        fun createOrderHeader(context: Context): LinearLayout {
            val layout = LinearLayout(context)
            layout.orientation = LinearLayout.HORIZONTAL
            layout.setPadding(10, 10, 0, 20)
            layout.layoutParams = LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT, 1F)

            layout.addView(createTextView(context, context.getString(R.string.product)))
            layout.addView(createTextView(context, context.getString(R.string.option)))
            layout.addView(createTextView(context, context.getString(R.string.price)))
            layout.addView(createTextView(context, context.getString(R.string.person)))

            return layout
        }

        /**
         * Creates a TextView containing the product name
         */
        private fun createTextView(context: Context, text: String): TextView {
            val tv = TextView(context)
            tv.text = text
            tv.textSize = 22f
            tv.setTypeface(null, Typeface.BOLD);
            tv.setTextColor(context.resources.getColor(R.color.black))
            tv.layoutParams = LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT, 1F)
            return tv
        }
    }

}