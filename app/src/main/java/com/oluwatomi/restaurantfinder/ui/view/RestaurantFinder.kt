package com.oluwatomi.restaurantfinder.ui.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Cancel
import androidx.compose.material.icons.filled.SearchOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.oluwatomi.restaurantfinder.R
import androidx.compose.runtime.getValue
import androidx.compose.ui.text.style.TextAlign
import com.oluwatomi.restaurantfinder.data.viewModel.RestaurantViewModel
import androidx.lifecycle.viewmodel.compose.viewModel


@Composable
fun RestaurantFinder(restaurantViewModel: RestaurantViewModel = viewModel()) {
    val restaurants by restaurantViewModel.restaurant.collectAsState()

    Column(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize().background(Color(0xfff0f4fa)))
    {
        Text(
            text = stringResource(id = R.string.title),
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(top = 60.dp)
        )
        Row(Modifier.fillMaxWidth().padding(12.dp)) {
            OutlinedTextField(
                value = restaurantViewModel.postcode,
                onValueChange = { restaurantViewModel.updatePostcode(it) },
                label = {
                    Text(
                        text = stringResource(id = R.string.label),
                        fontSize = 15.sp
                    ) },
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.White,
                    unfocusedContainerColor = Color.White,
                ),
                supportingText = {
                    if (restaurantViewModel.hasPostCodeError) {
                        Text(
                            text = stringResource(id = R.string.postcodeError),
                            color = MaterialTheme.colorScheme.error
                        )
                    }
                },
                singleLine = true,
                maxLines = 1,
                isError = restaurantViewModel.hasPostCodeError,
                trailingIcon = {
                    IconButton(onClick = {
                        restaurantViewModel.updatePostcode("")
                        restaurantViewModel.updateHasPostcodeError(false)
                    }) {
                        Icon(
                            Icons.Filled.Cancel,
                            "error has occurred",
                            tint = if (restaurantViewModel.hasPostCodeError) MaterialTheme.colorScheme.error else Color.Unspecified)
                    }
                 }
            )
            Button(
                onClick = {
                    if (restaurantViewModel.hasPostCodeError) {
                        restaurantViewModel.updateHasPostcodeError(false)
                    }
                    if (restaurantViewModel.postcode.trim().length < 3) {
                        restaurantViewModel.updateHasPostcodeError(true)
                    } else {
                        restaurantViewModel.updateHasSearched(true)
                        restaurantViewModel.updateRestaurants()
                    }
                },
                colors = ButtonDefaults.buttonColors(Color(0XFFE86051)),
                shape = RoundedCornerShape(5.dp),
                modifier = Modifier.height(65.dp)
                    .width(150.dp)
                    .padding(
                        top = 8.dp,
                        start = 5.dp
                    )
            ) {
                Text(
                    text = stringResource(id = R.string.buttonText),
                    fontSize = 15.sp,
                )
            }
        }
        if (!restaurantViewModel.loading && restaurants.isEmpty()){
            Column(
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxWidth().background(Color(0xfff0f4fa)).padding(top = 32.dp)
            ) {
                Icon(Icons.Filled.SearchOff, stringResource(id = R.string.searchOffIconDescription), modifier = Modifier.size(64.dp))
                Text(
                    text = if (!restaurantViewModel.hasSearched)
                        stringResource(id = R.string.restaurantLandingScreenText)
                    else
                        stringResource(id = R.string.searchOffIconDescription),
                    fontSize = 32.sp,
                    textAlign = TextAlign.Center
                )
            }
        }

        if (restaurantViewModel.loading){
            CircularProgressIndicator(modifier = Modifier.size(64.dp).padding(top = 32.dp))
        }

        if (!restaurantViewModel.loading && restaurants.isNotEmpty()) {
            LazyColumn() {
                items(restaurants) {restaurant ->
                    RestaurantCard(restaurant)
                }
            }
        }

    }
}


@Preview(showBackground = true)
@Composable
fun RestaurantFinderPreview(){
    RestaurantFinder()
}