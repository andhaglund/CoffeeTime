package com.example.coffeetime.models

class Order() {

    val orderLines = mutableListOf<OrderLine>()
    var isOpen = true
    var owner = ""

    fun addOrderLine(orderLine: OrderLine) {
        this.orderLines.add(orderLine)
    }

    fun closeOrder(owner: String) {
        this.isOpen = !this.isOpen
        this.owner = owner
    }

    fun openOrder(owner: String) {
        if (this.owner == owner) {
            this.isOpen = !this.isOpen
            this.owner = ""
        }
    }

}