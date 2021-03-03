package com.example.androiddevchallenge.model

import java.io.Serializable

class Cat : Serializable {
    val name: String
    val picture: Int
    val description: String
    var isAdopted: Boolean

    constructor(name: String, picture: Int, description: String, isAdopted: Boolean) {
        this.name = name
        this.picture = picture
        this.description = description
        this.isAdopted = isAdopted
    }
}
