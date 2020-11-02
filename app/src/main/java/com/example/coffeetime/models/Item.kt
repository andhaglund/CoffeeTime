package com.example.coffeetime.models

/**
 * Class for holding the different coffee types. Named "Item" to make the model
 * more flexible to future extensions (cake, smoothies etc)
 */
class Item (val name: String,
            val price: Float,
            val optionGroup: OptionGroup = OptionGroup.NONE,
            val category: Category = Category.COFFEE) {

}