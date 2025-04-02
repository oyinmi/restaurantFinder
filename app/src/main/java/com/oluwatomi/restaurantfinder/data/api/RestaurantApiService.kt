package com.oluwatomi.restaurantfinder.data.api

import com.oluwatomi.restaurantfinder.data.models.RestaurantApiResponse
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import retrofit2.converter.kotlinx.serialization.asConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

private const val  BASE_URL = "https://uk.api.just-eat.io"
private val JsonSerialiser = Json { ignoreUnknownKeys = true }
private val retrofit = Retrofit.Builder()
    .addConverterFactory(JsonSerialiser.asConverterFactory("application/json".toMediaType()))
    .baseUrl(BASE_URL)
    .build()

interface RestaurantApiService {
    @GET("/discovery/uk/restaurants/enriched/bypostcode/{postcode}")
    suspend fun getRestaurants(@Path("postcode") postcode: String): RestaurantApiResponse
}

object RestaurantApi {
    val retrofitService: RestaurantApiService by lazy {
        retrofit.create(RestaurantApiService::class.java)
    }
}
