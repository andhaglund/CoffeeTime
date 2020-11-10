package com.example.coffeetime.models

import android.content.SharedPreferences.Editor
import java.io.Serializable


class User(val firstName: String,
           val lastName: String,
           val phoneNumber: String) : Serializable {

}