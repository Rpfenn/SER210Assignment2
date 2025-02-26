package edu.quinnipiac.ser210.rpfassignment2.screens

import CountryList
import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import edu.quinnipiac.ser210.rpfassignment2.viewmodel.CountryViewModel


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailsScreen(navController: NavController,
                  countryName:String?){
    val countryList = CountryList.filter{ country ->
        country.name == countryName
    }

        Column(
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Top
        ){
            Image(
                painterResource(countryList[0].map),
                contentDescription = null,
                modifier = Modifier.fillMaxWidth().size(300.dp)
            )

//

            HorizontalDivider(modifier = Modifier.padding(3.dp))
            Text(text = countryList[0].name,
                fontSize = 50.sp,
                textAlign = TextAlign.Center)


            Text(text = "Fact: ${countryList[0].fact}",
                style = MaterialTheme.typography.titleLarge)
        }



}
