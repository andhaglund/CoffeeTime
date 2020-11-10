package com.example.coffeetime

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.coffeetime.models.*
import com.example.coffeetime.utilities.ProductUtilities
import kotlinx.android.synthetic.main.activity_orderline.*

class OrderLineActivity : AppCompatActivity() {

    private lateinit var owner: User
    private val products: List<Product> = ProductUtilities.getProducts()
    private val options: List<ProductOption> = ProductUtilities.getProductOptions()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_orderline)

//        owner = intent.extras!!.getSerializable("user") as User

        for (product in products) {
            orderline_layout.addView(product.createProductView(this))
        }
    }

    fun onSubmit() {

        val intent = Intent(this, OrderLineActivity::class.java)
//        intent.putExtra()
        startActivity(intent)
    }


}