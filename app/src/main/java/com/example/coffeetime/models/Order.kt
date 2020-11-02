package com.example.coffeetime.models

class Order() {

    val orderLines = mutableListOf<OrderLine>()
    var open = true
    var owner = ""

    fun addOrderLine(orderLine: OrderLine) {
        this.orderLines.add(orderLine)
    }

    fun removeOrderLine(index: Int, owner: String) {
        if(this.orderLines[index].ownerId != owner) {
            this.orderLines.removeAt(index)
        }
    }

    fun closeOrder(owner: String) {
        this.open = !this.open
        this.owner = owner
    }

    fun openOrder(owner: String) {
        if (this.owner == owner) {
            this.open = !this.open
            this.owner = ""
        }
    }

    fun summarizeOrder() {

    }

}