package edu.msoe.mattsona

import java.util.Date

data class Car (
    val id: Int,
    val color: String,
    val make: String,
    val modelYear: Int,
    val purchaseDate: Date?
)