package com.oluwatomi.restaurantfinder.ui.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.MenuBook
import androidx.compose.material.icons.filled.Fastfood
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.oluwatomi.restaurantfinder.data.models.Restaurant


@Composable
fun RestaurantCard(restaurant: Restaurant) {
    Card(
        modifier = Modifier.fillMaxWidth().padding(horizontal = 10.dp, vertical = 8.dp),
        elevation = CardDefaults.cardElevation(5.dp),
        colors = CardDefaults.cardColors())
    {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(restaurant.name, fontWeight = FontWeight.Bold, fontSize = 18.sp)
            Row {
                Icon(Icons.Filled.Fastfood, "restaurant menu")
                Text(restaurant.cuisines.joinToString { it.name }, fontSize = 14.sp)
            }
            Row {
                Icon(Icons.Filled.Star, "restaurant rating", tint = Color(0XFFBF9000))
                Text("${restaurant.rating.starRating}", fontSize = 14.sp)
            }
            Row {
                Icon(Icons.Filled.LocationOn, "restaurant location", tint = Color(0XFFCC0000))
                Text(restaurant.address.city, fontSize = 14.sp)
            }

        }
    }
}