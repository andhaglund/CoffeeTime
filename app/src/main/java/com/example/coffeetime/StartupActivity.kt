package com.example.coffeetime

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText

class StartupActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_startup)

        findViewById<Button>(R.id.startup_next).setOnClickListener {

            val firstName = findViewById<TextInputEditText>(R.id.input_first_name).text;
            val lastName = findViewById<TextInputEditText>(R.id.input_last_name).text;
            val phoneNumber = findViewById<TextInputEditText>(R.id.input_phone_number).text;
            val company = findViewById<TextInputEditText>(R.id.input_company).text;
            val companyCode = findViewById<TextInputEditText>(R.id.input_company_code).text;

            print("<----------- TeTESt---------->")
            print("<---------$firstName, $lastName, $phoneNumber, $company, $companyCode --------->")

            // Navigate to main activity
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}