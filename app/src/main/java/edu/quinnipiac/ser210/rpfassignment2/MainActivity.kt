package edu.quinnipiac.ser210.rpfassignment2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
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
                GreetingPreview()
            }
        }
    }
}




@Composable
fun LargeCoverImage(modifier:Modifier = Modifier){
    Image(
        painterResource(R.drawable.goodwillhunting),
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = Modifier
//            .height(190.dp)
//            .width(150.dp)
            .fillMaxWidth().height(450.dp)
            .clip(RoundedCornerShape(15.dp))
    )
}

@Composable
fun BottomSection(name:String, stars: Int, length:String, lang:String, rating:String, review:String,modifier:Modifier = Modifier.fillMaxHeight()){
    Column(modifier = Modifier.fillMaxWidth().padding(top = 400.dp)){
        SmallCoverSection(name, stars)
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
fun SmallCoverSection(name:String, stars:Int, modifier:Modifier = Modifier){
    Row{
        Image(
            painterResource(R.drawable.goodwillhunting),
            contentDescription = null,
            modifier = Modifier.size(175.dp)
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
fun GreetingPreview() {
    RPFAssignment2Theme {
        Box{
            LargeCoverImage()
            BottomSection("Good Will Hunting", 5, "1:37","Eng", "9.8", "50+")
        }
    }
}

@Composable
fun MoviePage(){
    Box{
        LargeCoverImage()
        BottomSection("Good Will Hunting", 5, "1:37","Eng", "9.8", "50+")
    }
}