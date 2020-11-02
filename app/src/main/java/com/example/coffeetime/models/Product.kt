package com.example.coffeetime.models

/**
 * Class for holding the different coffee types. Named "Product" to make the model
 * more flexible to future extensions (cake, smoothies etc)
 */
class Product (val name: String,
               val price: Float,
               val optionGroup: OptionGroup = OptionGroup.NONE,
               val category: Category = Category.COFFEE) {

}