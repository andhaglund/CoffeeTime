package com.example.coffeetime.models

import java.io.Serializable

class User(val firstName: String,
           val lastName: String,
           val phoneNumber: String) : Serializable {

    constructor() : this("", "", "")
}