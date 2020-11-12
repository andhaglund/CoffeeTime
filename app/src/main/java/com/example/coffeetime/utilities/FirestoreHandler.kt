package com.example.coffeetime.utilities

import android.content.Context
import android.util.Log
import android.widget.LinearLayout
import com.example.coffeetime.models.*
import com.google.firebase.firestore.FirebaseFirestore
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter


class FirestoreHandler {

    companion object {

        private val db = FirebaseFirestore.getInstance()

        /**
         * Adds orderLine to Firebase
         */
        fun addOrderLine(orderLine: OrderLine) {
            db.collection("orderLines")
                .add(orderLine)
                .addOnSuccessListener { Log.d("Firebase:", "Successfully added orderLine $orderLine") }
                .addOnFailureListener { Log.e("Firebase:", "Failed to add orderLine $orderLine") }
        }

        /**
         * Collects all orderLines with today's date from Firestore and adds them to the
         * parentLayout.
         * ( Future update: Return orderLines and add them to view in caller by using coroutines)
         */
        fun getOrderLines(context: Context, parentLayout: LinearLayout) {
            db.collection("orderLines").whereEqualTo("date",
                LocalDateTime.now().format(DateTimeFormatter.ISO_DATE))
                .get().addOnSuccessListener { collection ->
                    collection.documents.forEach{
                        val orderLine = it.toObject(OrderLine::class.java)
                        if (orderLine != null) {
                            parentLayout.addView(orderLine.createOrderLineView(context))
                            Log.d("Firebase", "Document: ${orderLine?.product?.name}")
                        }
                    }
                }
        }
    }
}