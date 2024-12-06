package com.example.finalproject2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
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
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(modifier: Modifier = Modifier) {
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
        Text(
            text = "Money Tracker",
            color = textColor,
            modifier = modifier

        )
        Text(
            text = stringResource(R.string.totalMoney),
            style = MaterialTheme.typography.displaySmall,
            fontSize = 10.sp,
            modifier = Modifier
                .align(alignment = Alignment.Start)
        )
        Spacer(modifier = Modifier.height(40.dp))
    }
}

@Composable
fun moneyClicker(
    textLabelResourceId: Int,
    drawableResourceId: Int,
    contentDescriptionResourceId: Int,
    onImageClick: () -> Unit,
    modifier: Modifier = Modifier
){
    Box(
        modifier = modifier
    ){
        Column(modifier = modifier) {
            Button(
                onClick = onImageClick,
            ){
                Image(
                    painter = painterResource(drawableResourceId),
                    contentDescription = stringResource(contentDescriptionResourceId),
                )
            }
        }
    }

}

fun Button(onClick: () -> Unit) {

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    FinalProject2Theme {
        Greeting()
    }
}