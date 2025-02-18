package edu.quinnipiac.ser210.rpfassignment2

import Country
import CountryList
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import edu.quinnipiac.ser210.rpfassignment2.ui.theme.RPFAssignment2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RPFAssignment2Theme {
                MoviePage("Good Will Hunting", 5, "1:37","Eng", "9.8", "50+", R.drawable.goodwillhunting, modifier = Modifier)
                CountryLazyList(CountryList)
            }
        }
    }
}




@Composable
fun LargeCoverImage(image:Int,modifier:Modifier = Modifier){
    Image(
        painterResource(image),
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = Modifier
//            .height(190.dp)
//            .width(150.dp)
            .fillMaxWidth().height(520.dp)
            .clip(RoundedCornerShape(15.dp))
    )
}

@Composable
fun BottomSection(name:String, stars: Int, length:String, lang:String, rating:String, review:String,image:Int, modifier:Modifier = Modifier.fillMaxHeight()){
    Column(modifier = Modifier.fillMaxWidth().padding(top = 500.dp)){
        SmallCoverSection(name, stars, image)
        Row(
            horizontalArrangement = Arrangement.spacedBy(50.dp),
            modifier = Modifier.padding(0.dp, 30.dp)
        ){
            Column{
                Text(text = "Length", fontSize = 15.sp,  fontFamily = FontFamily.Serif)
                Text(text = length, fontSize = 15.sp, fontWeight = FontWeight.Bold)
            }

            Column{
                Text(text = "Lang", fontSize = 15.sp,  fontFamily = FontFamily.Serif)
                Text(text = lang, fontSize = 15.sp, fontWeight = FontWeight.Bold)
            }
            Column{
                Text(text = "Rating", fontSize = 15.sp,  fontFamily = FontFamily.Serif)
                Text(text = rating, fontSize = 15.sp, fontWeight = FontWeight.Bold)
            }
            Column{
                Text(text = "Review", fontSize = 15.sp,  fontFamily = FontFamily.Serif)
                Text(text = review, fontSize = 15.sp, fontWeight = FontWeight.Bold)
            }
        }

    }
}


@Composable
fun SmallCoverSection(name:String, stars:Int, image:Int,modifier:Modifier = Modifier){
    Row{
        Image(
            painterResource(image),
            contentDescription = null,
            modifier = Modifier.size(200.dp)
                .clip(RoundedCornerShape(25.dp))
        )
        Column{
            Text(text = name, fontSize = 20.sp, modifier=Modifier.padding(start=3.dp, top = 90.dp, end = 15.dp))
            Row(modifier=Modifier.fillMaxWidth().padding(10.dp)){
                for(i in 0..stars-1){
                    Icon(
                        imageVector = Icons.Filled.Star,
                        contentDescription = null
                    )
                }
            }

        }


    }
}




@Preview(showBackground = true)
@Composable
fun MoviePreview() {
    RPFAssignment2Theme {
        Box{
            LargeCoverImage(R.drawable.goodwillhunting)
            BottomSection("Good Will Hunting", 5, "1:37","Eng", "9.8", "50+", R.drawable.goodwillhunting)
        }
    }
}

@Composable
fun MoviePage(name:String, stars:Int, length:String, lang:String, rating:String, review:String, image:Int, modifier: Modifier){
    Box{
        LargeCoverImage(image)
        BottomSection(name, stars, length, lang, rating, review, image)
    }
}

@Composable
fun CountryInfo(flag: Int, name:String, currency:String){
    Row(
        modifier = Modifier.fillMaxWidth()
            .padding(8.dp)
    ){
        Image(painterResource(flag),
            contentDescription = null,
            modifier = Modifier.size(75.dp)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Column{
            Text(text = "Country: $name", fontSize = 30.sp)
            Text(text = "Currency: $currency", fontSize = 24.sp)
        }
    }
}

@Composable
fun CountryLazyList(countryList: List<Country>){
    LazyColumn {
        items(countryList){country->
            CountryInfo(country.flag, country.name, country.currency )
            HorizontalDivider(thickness=2.dp)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CountryPreview(){
    //CountryInfo(R.drawable.india, "India", "New Dheli")
    CountryLazyList(CountryList)
}