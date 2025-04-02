package com.oluwatomi.restaurantfinder

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.oluwatomi.restaurantfinder.ui.theme.RestaurantFinderTheme
import com.oluwatomi.restaurantfinder.ui.view.RestaurantFinder

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RestaurantFinderTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize()
                ) {
                    RestaurantFinder()
                }
            }
        }
    }
}