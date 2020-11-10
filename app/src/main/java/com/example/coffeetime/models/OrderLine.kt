package com.example.coffeetime.models

import java.io.Serializable


class OrderLine(val product: Product,
                val option: ProductOption,
                val ownerId: String,
                val price: Float,
                val description: String = "") : Serializable {
}