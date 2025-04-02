package com.oluwatomi.restaurantfinder.ui.view

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.material.icons.filled.Clear
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.oluwatomi.restaurantfinder.R
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.oluwatomi.restaurantfinder.data.models.Restaurant
import com.oluwatomi.restaurantfinder.data.models.getRestaurants
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit


@Composable
fun RestaurantFinder() {
    var restaurants = remember { mutableStateListOf<Restaurant>() }
    var postcode by remember { mutableStateOf<String>("") }
    var loading by remember { mutableStateOf<Boolean>(false) }
    var hasSearched by remember { mutableStateOf<Boolean>(false) }
    var hasPostCodeError by remember { mutableStateOf<Boolean>(false) }

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
                value = postcode,
                onValueChange = { postcode = it },
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
                    if (hasPostCodeError) {
                        Text(
                            text = "Enter a valid postcode",
                            color = MaterialTheme.colorScheme.error
                        )
                    }
                },
                singleLine = true,
                maxLines = 1,
                isError = hasPostCodeError,
                trailingIcon = {
                    IconButton(onClick = {
                        postcode = ""
                        hasPostCodeError = false
                    }) {
                        Icon(Icons.Filled.Cancel, "error has occurred", tint = if (hasPostCodeError) MaterialTheme.colorScheme.error else Color.Unspecified)
                    }
                 }
            )
            Button(
                onClick = {
                    if (hasPostCodeError) {
                        hasPostCodeError = false;
                    }
                    if (postcode.trim().length < 3) {
                        hasPostCodeError = true
                    } else {
                        hasSearched = true
                        restaurants.addAll(getRestaurants())
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
                    text = "Search",
                    fontSize = 15.sp,
                )
            }
        }
        if (restaurants.isEmpty()){
            Column(
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxWidth().background(Color(0xfff0f4fa)).padding(top = 32.dp)
            ) {
                Icon(Icons.Filled.SearchOff, "no search result", modifier = Modifier.size(64.dp))
                Text(
                    text = if (!hasSearched) "Enter your postcode to get a list of restaurant" else "No search result",
                    fontSize = 32.sp,
                    textAlign = TextAlign.Center
                )
            }
        }

        if (loading){
            CircularProgressIndicator(modifier = Modifier.size(64.dp).padding(top = 32.dp))
        }

        if (restaurants.isNotEmpty()) {
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