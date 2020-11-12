package com.example.coffeetime

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.coffeetime.models.User
import com.example.coffeetime.utilities.DataHandler
import kotlinx.android.synthetic.main.activity_registration.*


class RegistrationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        if (DataHandler.localUserExists(this)) {
            navigateToMain()
        }
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)

        submit_button.setOnClickListener { registerUser() }
    }

    /**
     * Function to be called on button click. Adds user to sharedPreferences.
     * Future extension: Add to Firestore
     */
    private fun registerUser() {
        val firstName = first_name_input.text.toString()
        val lastName = last_name_input.text.toString()
        val phoneNumber = phone_input.text.toString()

        if (firstName == "" || lastName == "" || phoneNumber == "") {
            Toast.makeText(this, "All fields must be filled out!",
                    Toast.LENGTH_SHORT).show()
            return
        }

        DataHandler.setLocalUser(this, User(firstName, lastName, phoneNumber))
        navigateToMain()
    }

    /**
     * Navigate to main class using an Intent object
     */
    private fun navigateToMain() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}