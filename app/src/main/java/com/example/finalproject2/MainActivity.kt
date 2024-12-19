package com.example.finalproject2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.finalproject2.ui.theme.FinalProject2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FinalProject2Theme {


                }
            }
        }
    }

var isVentorAveOwned = false
var isAlanticAveOwned = false
var isMarvinGardensOwned = false

@Composable
fun Monopoly(modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.background(
            color = Color.White
        )
    ){
        Logo(
            modifier
                .align(alignment = Alignment.CenterHorizontally),
                Color.Black,
        )
    }
}

fun PropCheck(){

    if(isVentorAveOwned == true){
        println("You Own Ventor Ave!")
    }else if(isAlanticAveOwned == true){
        println("You Own Alantic Ave!")
    }else if(isMarvinGardensOwned == true){
        println("You Own Marvin Gardens!")
    }

}

@Composable
fun Logo(modifier: Modifier, textColor: Color){
    Column(horizontalAlignment = Alignment.CenterHorizontally){
        Image(
            painter = painterResource(id = R.drawable.amonopoly),
            contentDescription = null,
            contentScale = ContentScale.Fit,
            modifier = modifier
                .height(40.dp)
                .padding(2.dp)
                .background(
                    color = Color.White
                )

        )
//        Image(
//            painter = painterResource(id = R.drawable.propword),
//            contentDescription = null,
//            modifier = Modifier.clickable(onClick = { PropCheck() })
//        )
        Text(
            text = "Properties",
            color = Color.White,
            modifier = modifier
                .clickable(
                    onClick = { PropCheck() }
                )
                .background(color = Color.Black)


        )

        Button(
            colors = ButtonDefaults.buttonColors(containerColor = Color.White),
            onClick = { isVentorAveOwned = true },
            shape = RoundedCornerShape(topStart = 10.dp, bottomEnd = 10.dp),





        ){
            Image(
                painter = painterResource(id = R.drawable.ventor_ave),
                contentDescription = null
            )

        }

        }

    Button(
        colors = ButtonDefaults.buttonColors(containerColor = Color.White),
        onClick = { isAlanticAveOwned = true },
        shape = RoundedCornerShape(topStart = 10.dp, bottomEnd = 10.dp)




    ){
        Image(
            painter = painterResource(id = R.drawable.alantic_ave),
            contentDescription = null
        )

    }
    Button(
        colors = ButtonDefaults.buttonColors(containerColor = Color.White),
        onClick = { isMarvinGardensOwned = true},
        shape = RoundedCornerShape(topStart = 10.dp, bottomEnd = 10.dp)




    ){
        Image(
            painter = painterResource(id = R.drawable.marvingardens),
            contentDescription = null
        )

    }

    }



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    FinalProject2Theme {
        Monopoly()
    }
}