package com.oluwatomi.restaurantfinder.data.models

import kotlinx.serialization.Serializable

@Serializable
data class RestaurantApiResponse(
    val restaurants: List<Restaurant>
)
