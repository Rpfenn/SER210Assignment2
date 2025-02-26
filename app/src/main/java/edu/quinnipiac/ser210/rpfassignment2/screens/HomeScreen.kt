package edu.quinnipiac.ser210.rpfassignment2.screens

import Country
import CountryList
import android.annotation.SuppressLint
import android.view.RoundedCorner
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import edu.quinnipiac.ser210.rpfassignment2.navigation.AppScreens
import edu.quinnipiac.ser210.rpfassignment2.viewmodel.CountryViewModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavController){
    MainContent(navController = navController)
}


@Composable
fun MainContent(
    navController: NavController,
    countryList: List<Country> = CountryList){
    Column(modifier = Modifier.padding(12.dp)){
        LazyColumn{
            items(items = countryList){
                CountryInfo(country = it){ country ->

                    navController.navigate(route = AppScreens.DetailsScreen.name+"/$country")

                }
            }
        }
    }

}




@Composable
fun CountryInfo(country: Country = CountryList[0], onItemClick: (String) -> Unit = {}){
    Card(modifier = Modifier
        .padding(4.dp)
        .fillMaxWidth()
        .clickable{
            onItemClick(country.name)
        },
        shape = RoundedCornerShape(corner = CornerSize(16.dp)),){

        Row(
            modifier = Modifier.fillMaxWidth()
                .padding(8.dp)
        ){
            Image(
                painter = painterResource(id = country.flag),
                contentDescription = null,
                modifier = Modifier.size(75.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Column{
                Text(text = "Country: ${country.name}", fontSize = 30.sp)
                Text(text = "Currency: ${country.currency}", fontSize = 24.sp)
            }
        }
    }

}