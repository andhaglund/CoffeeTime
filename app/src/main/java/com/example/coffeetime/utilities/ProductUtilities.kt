package com.example.coffeetime.utilities

import com.example.coffeetime.models.Category
import com.example.coffeetime.models.Product
import com.example.coffeetime.models.ProductOption

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

            return listOf(coffee, latte, cappuccino, mocha, espresso)
        }
    }


}