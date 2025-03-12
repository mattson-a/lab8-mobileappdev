package edu.msoe.mattsona

import androidx.lifecycle.ViewModel
import java.util.Date
import java.util.UUID
import kotlin.random.Random

class ApplicationViewModel : ViewModel() {
    val cars: MutableList<Car> = mutableListOf()

    init {
        //initialize 20 car objects to manage, leave date empty
        val colors = listOf("Red", "Blue", "Black", "Silver", "White", "Yellow", "Green", "Orange")
        val makes = listOf("Ford", "Chevrolet", "Mercedes", "Buick", "GMC", "Toyota", "Honda", "Subaru")

        for (i in 0 .. 19) {
            cars.add(Car(i, colors.random(), makes.random(), Random.nextInt(1990, 2025), null))
        }
    }
}