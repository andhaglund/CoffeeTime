package com.example.coffeetime.utilities

import android.content.Context
import android.content.SharedPreferences
import com.example.coffeetime.models.User


class DataHandler {
    companion object {
        fun getLocalUser(context: Context): User {
            val firstName = loadLocalData(context, "firstName").orEmpty()
            val lastName = loadLocalData(context, "lastName").orEmpty()
            val phoneNumber = loadLocalData(context, "phoneNumber").orEmpty()
            return User(firstName, lastName, phoneNumber)
        }

        fun setLocalUser(context: Context, user: User) {
            saveLocalData(context, "firstName", user.firstName)
            saveLocalData(context, "lastName", user.lastName)
            saveLocalData(context, "phoneNumber", user.phoneNumber)
        }

        fun localUserExists(context: Context): Boolean {
            val firstName = loadLocalData(context, "firstName").orEmpty()
            val lastName = loadLocalData(context, "lastName").orEmpty()
            val phoneNumber = loadLocalData(context, "phoneNumber").orEmpty()

            return firstName.isNotEmpty() && lastName.isNotEmpty() && phoneNumber.isNotEmpty()
        }

        /**
         * Gets the value of the given key from local shared preferences.
         * Returns empty string if no value is found
         */
        private fun loadLocalData(context: Context, key: String): String? {
            val sharedPreferences: SharedPreferences =
                    context.getSharedPreferences("sharedPrefs", Context.MODE_PRIVATE)

            return sharedPreferences.getString(key, "")
        }

        /**
         * Adds a key/value pair to the local shared preferences
         */
        private fun saveLocalData(context: Context, key: String, value: String) {
            val sharedPreferences: SharedPreferences =
                    context.getSharedPreferences("sharedPrefs", Context.MODE_PRIVATE)
            val editor = sharedPreferences.edit()
            editor.apply {
                putString(key, value)
            }.apply()
        }
    }
}