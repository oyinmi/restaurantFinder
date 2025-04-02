package com.oluwatomi.restaurantfinder.data.models

fun getRestaurants(): List<Restaurant> {
    return listOf(
        Restaurant(
            "id1",
            "Just Eat London",
            listOf(
                Cuisine(
                    name = "africa",
                ),
                Cuisine(
                    name = "indian",
                ),
            ),
            Rating(
                4.1
            ),
            Address(
                "2 Fleet Place",
                "London",
                "EC4M 7RF"
            )
        ),
        Restaurant(
            "id2",
            "Just Eat Essex",
            listOf(
                Cuisine(
                    name = "asia",
                ),
                Cuisine(
                    name = "european",
                ),
            ),
            Rating(
                4.7
            ),
            Address(
                "High St",
                "Essex",
                "CO16 0DY"
            )
        ),
    )
}