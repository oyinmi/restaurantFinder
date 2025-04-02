package com.oluwatomi.restaurantfinder.data.viewModel

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.oluwatomi.restaurantfinder.data.models.Restaurant
import com.oluwatomi.restaurantfinder.data.models.getRestaurants
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch


class RestaurantViewModel: ViewModel() {
    var postcode by mutableStateOf<String>("")
        private set

    var loading by mutableStateOf<Boolean>(false)
        private set

    var hasSearched by mutableStateOf<Boolean>(false)
        private set

    var hasPostCodeError by mutableStateOf<Boolean>(false)
        private set

    private val _restaurant = MutableStateFlow<List<Restaurant>>(emptyList())
    val restaurant: StateFlow<List<Restaurant>> = _restaurant.asStateFlow()

    fun updateRestaurants() {
        viewModelScope.launch {
            val restaurantResponse: List<Restaurant> = getRestaurants()
            _restaurant.value = restaurantResponse.subList(0, if (restaurantResponse.size > 10) 10 else restaurantResponse.size)
        }
    }

    fun updatePostcode(newPostCode: String) {
        postcode = newPostCode;
    }

    fun updateHasSearched(newHasSearch: Boolean) {
        hasSearched = newHasSearch;
    }

    fun updateHasPostcodeError(newHasPostCodeError: Boolean) {
        hasPostCodeError = newHasPostCodeError;
    }
}