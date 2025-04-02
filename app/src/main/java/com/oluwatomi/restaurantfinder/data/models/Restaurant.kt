package com.oluwatomi.restaurantfinder.data.models

import kotlinx.serialization.Serializable

@Serializable
data class Address(
    val firstLine: String,
    val city: String,
    val postalCode: String,
)

@Serializable
data class Rating(
    val starRating: Double,
)

@Serializable
data class Cuisine(
    val name: String,
)

@Serializable
data class Restaurant(
    val id: String,
    val name: String,
    val cuisines: List<Cuisine>,
    val rating: Rating,
    val address: Address,
)
