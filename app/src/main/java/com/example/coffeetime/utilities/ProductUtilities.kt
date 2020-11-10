package com.example.coffeetime.utilities

import com.example.coffeetime.models.Category
import com.example.coffeetime.models.OptionGroup
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
            val latte = Product("Caffè Latte", 42F, OptionGroup.STRENGTH, Category.COFFEE)
            val mocha = Product("Caffè Mocca", 45F, OptionGroup.STRENGTH, Category.COFFEE)
            val cappuccino = Product("Cappuccino", 42F, OptionGroup.STRENGTH, Category.COFFEE)
            val coffee = Product("Coffee", 32F, OptionGroup.NONE, Category.COFFEE)
            val espresso = Product("Espresso", 35F, OptionGroup.STRENGTH, Category.COFFEE)

            return listOf(latte, mocha, cappuccino, coffee, espresso)
        }

        /**
         * Future extension: options are collected from Firestore
         */
        fun getProductOptions(): List<ProductOption> {
            val single = ProductOption("Single", OptionGroup.STRENGTH, 0F)
            val double = ProductOption("Double", OptionGroup.STRENGTH, 3F)

            return listOf(single, double)
        }

    }


}