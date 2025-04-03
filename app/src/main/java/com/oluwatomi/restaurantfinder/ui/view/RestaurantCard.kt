package com.oluwatomi.restaurantfinder.ui.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Fastfood
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.oluwatomi.restaurantfinder.data.models.Restaurant


@Composable
fun RestaurantCard(restaurant: Restaurant) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp),
        elevation = CardDefaults.cardElevation(3.dp),
        colors = CardDefaults.cardColors())
    {
        Column(modifier = Modifier.padding(16.dp)) {
            Row(
                modifier = Modifier.padding(bottom = 8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                AsyncImage(
                    model= ImageRequest.Builder(LocalContext.current)
                        .data(restaurant.logoUrl)
                        .crossfade(true)
                        .build(),
                    contentDescription = "restaurant image",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.padding(end = 8.dp)
                )
                Text(restaurant.name, fontWeight = FontWeight.Bold, fontSize = 18.sp)
            }
            Row {
                Icon(Icons.Filled.Fastfood, "restaurant menu")
                Text(restaurant.cuisines.joinToString { it.name }, fontSize = 16.sp, modifier = Modifier.padding(start = 4.dp))
            }
            Row {
                Icon(Icons.Filled.Star, "restaurant rating", tint = Color(0XFFBF9000))
                Text("${restaurant.rating.starRating}", fontSize = 16.sp)
            }
            Row {
                Icon(Icons.Filled.LocationOn, "restaurant location", tint = Color(0XFFCC0000))
                Text("${restaurant.address.firstLine}, ${restaurant.address.city}, ${restaurant.address.postalCode}", fontSize = 16.sp)
            }

        }
    }
}