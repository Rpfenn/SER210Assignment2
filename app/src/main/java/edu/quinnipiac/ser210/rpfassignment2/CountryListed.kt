package edu.quinnipiac.ser210.rpfassignment2

import androidx.compose.foundation.Image
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import edu.quinnipiac.ser210.rpfassignment2.ui.theme.RPFAssignment2Theme
import Country
import CountryList
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.HorizontalDivider

class CountryListed : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RPFAssignment2Theme {
                CountryPreview()
            }
        }
    }
}



//@Composable
//fun CountryInfo(flag: Int, name:String, currency:String){
//    Row(
//        modifier = Modifier.fillMaxWidth()
//            .padding(8.dp)
//    ){
//        Image(painterResource(flag),
//            contentDescription = null,
//            modifier = Modifier.size(40.dp)
//        )
//        Spacer(modifier = Modifier.width(8.dp))
//        Column{
//            Text(text = "Country: $name", fontSize = 14.sp)
//            Text(text = "Currency: $currency", fontSize = 12.sp)
//        }
//    }
//}
//
//@Composable
//fun CountryLazyList(countryList: List<Country>){
//    LazyColumn {
//        items(countryList){country->
//            CountryInfo(country.flag, country.name, country.currency )
//            HorizontalDivider(thickness=2.dp)
//        }
//    }
//}
//
//@Preview(showBackground = true)
//@Composable
//fun CountryPreview(){
//    //CountryInfo(R.drawable.india, "India", "New Dheli")
//    CountryLazyList(CountryList)
//}