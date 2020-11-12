package com.example.coffeetime.utilities

import android.content.Context
import android.graphics.Typeface
import android.widget.TextView
import com.example.coffeetime.R
import com.example.coffeetime.models.Category
import com.example.coffeetime.models.Product

/**
 * Class for handling products and productOptions functionality
 */
class ProductUtilities {

    companion object {
        /**
         * Future extension: products are collected from Firestore
         */
        fun getProducts(): List<Product> {
            val coffee = Product("Coffee", 32F, false, Category.COFFEE)
            val latte = Product("Caffè Latte", 42F, true, Category.COFFEE)
            val cappuccino = Product("Cappuccino", 42F, true, Category.COFFEE)
            val mocha = Product("Caffè Mocca", 45F, true, Category.COFFEE)
            val espresso = Product("Espresso", 35F, true, Category.COFFEE)
            val other = Product("Other", 0F, false, Category.OTHER)

            return listOf(coffee, latte, cappuccino, mocha, espresso, other)
        }

        /**
         * Create header for each product category
         */
        fun createProductCategoryHeaderView(context: Context, category: Category): TextView {
            val header = TextView(context)
            header.text = category.category
            header.textSize = 25f
            header.setTypeface(null, Typeface.BOLD);
            header.setPadding(10, 20, 10, 20)
            header.setTextColor(context.resources.getColor(R.color.black))
            return header
        }
    }


}