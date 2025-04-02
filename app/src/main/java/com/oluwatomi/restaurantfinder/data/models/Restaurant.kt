package com.oluwatomi.restaurantfinder.data.models

data class Address(
    val firstLine: String,
    val city: String,
    val postalCode: String,
)

data class Rating(
    val starRating: Double,
)

data class Cuisine(
    val name: String,
)

data class Restaurant(
    val id: String,
    val name: String,
    val cuisines: List<Cuisine>,
    val rating: Rating,
    val address: Address,
)
