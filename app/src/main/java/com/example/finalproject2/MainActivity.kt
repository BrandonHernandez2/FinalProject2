package com.example.finalproject2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.finalproject2.ui.theme.FinalProject2Theme
import java.text.NumberFormat

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FinalProject2Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    monopolyApp(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

var isVentorAveOwned = false
var isAlanticAveOwned = false
var isMarvinGardensOwned = false

@Composable
fun monopolyApp(modifier: Modifier = Modifier) {

    var totalMoney = 0
    var totalAmount = calcAmount(totalMoney);


    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.background(
            color = Color.White
        )
    ){
        Image(
            painter = painterResource(id = R.drawable.amonopoly),
            contentDescription = null,
            contentScale = ContentScale.Fit,
            modifier = modifier
                .height(30.dp)
                .padding(2.dp)
                .background(
                    color = Color.White
                )
        )
        Text(
            text = "Money Tracker, " +
                    "Dice Roller, " +
                    "Property Tracker",
            color = Color.Black,
            fontSize = 13.sp,
            modifier = Modifier
                .width(120.dp)

        )
        Text(
            text = stringResource(R.string.totalMoney, totalAmount),
            style = MaterialTheme.typography.displaySmall,
            fontSize = 10.sp,
            modifier = Modifier
                .align(alignment = Alignment.Start)
        )
        Button(
            colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.background),
            onClick = {
                totalMoney += 1
                calcAmount(totalMoney)
            }
        ){
            Image(
                painter = painterResource(R.drawable.a1bill),
                contentDescription = "A 1 Bill",
                modifier = Modifier
                    .width(60.dp)
                    .height(35.dp)
                    .background(Color.White)
            )
        }
        Button(
            colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.background),
            onClick =  {
                totalMoney += 5
                calcAmount(totalMoney);
            }
        ){
            Image(
                painter = painterResource(R.drawable.a5bill),
                contentDescription = "a 5 Bill",
                modifier = Modifier
                    .width(60.dp)
                    .height(35.dp)
            )
        }
        Button(
            colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.background),
            onClick = {
                totalMoney += 10
                calcAmount(totalMoney)
            }
        ){
            Image(
                painter = painterResource(R.drawable.a10bill),
                contentDescription = "a 10 Bill",
                modifier = Modifier
                    .width(60.dp)
                    .height(35.dp)
            )
        }
        Button(
            colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.background),
            onClick = {
                totalMoney += 20
                calcAmount(totalMoney)
            }
        ){
            Image(
                painter = painterResource(R.drawable.a20bill),
                contentDescription = "a 20 Bill",
                modifier = Modifier
                    .width(60.dp)
                    .height(35.dp)
            )
        }
        Button(
            colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.background),
            onClick = {
                totalMoney += 50
                calcAmount(totalMoney)
            }
        ){
            Image(
                painter = painterResource(R.drawable.a50bill),
                contentDescription = "a 50 Bill",
                modifier = Modifier
                    .width(60.dp)
                    .height(35.dp)
            )
        }
        Button(
            colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.background),
            onClick = {
                totalMoney += 100
                calcAmount(totalMoney)
            }
        ){
            Image(
                painter = painterResource(R.drawable.a100bill),
                contentDescription = "a 100 Bill",
                modifier = Modifier
                    .width(60.dp)
                    .height(35.dp)
            )
        }
        Button(
            colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.background),
            onClick = {
                totalMoney += 500
                calcAmount(totalMoney)
            }
        ){
            Image(
                painter = painterResource(R.drawable.a500bill),
                contentDescription = "a 500 Bill",
                modifier = Modifier
                    .width(60.dp)
                    .height(35.dp)
            )
        }
        DiceImageandImageForDie1(modifier = modifier)
        Column (
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier.background(
                color = Color.White
            )
        ){
            propertiesList(
                modifier
                    .align(alignment = Alignment.CenterHorizontally),
                Color.Black,
            )
        }

        Spacer(modifier = Modifier.height(10.dp))
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
fun propertiesList(modifier: Modifier, textColor: Color){
    Column(horizontalAlignment = Alignment.CenterHorizontally){
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

fun calcAmount(totalMoney: Int): String {
    var total = totalMoney
    return NumberFormat.getCurrencyInstance().format(total)
}

@Composable
fun DiceImageandImageForDie1(modifier: Modifier = Modifier) {

    var result by remember { mutableStateOf(1) }
    var result2 by remember { mutableStateOf(1) }
    val images = when(result){
        1 -> R.drawable.dieon1
        2 -> R.drawable.dieon2
        3 -> R.drawable.dieon3
        4 -> R.drawable.dieon4
        5 -> R.drawable.dieon5
        else -> {R.drawable.dieon6}
    }
    val images2 = when(result2){
        1 -> R.drawable.dieon1
        2 -> R.drawable.dieon2
        3 -> R.drawable.dieon3
        4 -> R.drawable.dieon4
        5 -> R.drawable.dieon5
        else -> {R.drawable.dieon6}
    }
    Column(modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally) {
        Image(painter = painterResource(images), contentDescription = result.toString(), Modifier
            .height(40.dp)
            .width(100.dp))

        Image(painter = painterResource(images2), contentDescription = result2.toString(), Modifier
            .height(40.dp)
            .width(40.dp))

        Button(
            onClick = { result = (1..6).random() },
        ) {
            Text(text = "Roll", fontSize = 14.sp)
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    FinalProject2Theme {
        monopolyApp()
    }
}