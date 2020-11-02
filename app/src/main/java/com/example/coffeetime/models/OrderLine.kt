package com.example.coffeetime.models



class OrderLine(val item: Item,
                val option: ItemOption,
                val cost: Double,
                val ownerId: String) {
}