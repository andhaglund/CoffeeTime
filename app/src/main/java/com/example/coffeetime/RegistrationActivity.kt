package com.example.coffeetime

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.coffeetime.models.User
import com.google.android.gms.tasks.Task
import com.google.firebase.functions.FirebaseFunctions
import com.google.firebase.functions.ktx.functions
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_registration.*


class RegistrationActivity : AppCompatActivity() {

    private lateinit var functions: FirebaseFunctions

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)

        functions = Firebase.functions

        submit_button.setOnClickListener { registerUser() }
    }

    private fun registerUser() {
        val firstName = first_name_input.text.toString()
        val lastName = last_name_input.text.toString()
        val phoneNumber = phone_input.text.toString()

        val user = User(firstName, lastName, phoneNumber)

        // Navigate to main activity
        val intent = Intent(this, OrderLineActivity::class.java)
        intent.putExtra("user", user)
        startActivity(intent)
    }

    private fun addUser(firstName: String, lastName: String, phoneNumber: String): Task<Int> {

        Log.i("addUser", firstName)
        // Create the arguments to the callable function, which are two integers
        val data = hashMapOf(
            "firstName" to firstName,
            "lastName" to lastName,
            "phoneNumber" to phoneNumber,
        )

        // Call the function and extract the operation from the result
        return functions
            .getHttpsCallable("addUser")
            .call(data)
            .continueWith { task ->
                // This continuation runs on either success or failure, but if the task
                // has failed then task.result will throw an Exception which will be
                // propagated down.
                val result = task.result?.data as Map<*, *>
                result["operationResult"] as Int
            }
    }
}