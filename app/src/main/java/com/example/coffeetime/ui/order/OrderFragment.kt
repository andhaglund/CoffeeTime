package com.example.coffeetime.ui.order

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.coffeetime.MainActivity
import com.example.coffeetime.R
import com.example.coffeetime.utilities.FirestoreHandler
import kotlinx.android.synthetic.main.fragment_order.*

class OrderFragment : Fragment() {

    private lateinit var orderViewModel: OrderViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        orderViewModel = ViewModelProvider(this).get(OrderViewModel::class.java)

        val root = inflater.inflate(R.layout.fragment_order, container, false)
        return root
    }
}