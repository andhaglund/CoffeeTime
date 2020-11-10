package com.example.coffeetime.models

/**
 * Enum class for storing different product options.
 * Example: Strength (single, double), size (small, medium, large), flavour etc.
 */
enum class ProductOption(val option: String,
                    val category: Category,
                    val additionalCost: Float) {

    SINGLE("Single", Category.COFFEE, 0F),
    DOUBLE("Double", Category.COFFEE, 3F),
    REGULAR("Regular", Category.ALL, 0F);
}