package com.example.coffeetime.models



class OrderLine(val product: Product,
                val option: ProductOption,
                val quantity: Int,
                val ownerId: String) {

    var price: Float = 0F

    init {
         price = product.price * quantity
    }

    fun editOrderLine(product: Product = this.product,
                      option: ProductOption = this.option,
                      quantity: Int = this.quantity): OrderLine {
        return OrderLine(product, option, quantity, this.ownerId)
    }
}