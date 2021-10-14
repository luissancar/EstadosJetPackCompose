package com.example.estadosjetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.estadosjetpackcompose.ui.theme.EstadosJetPackComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EstadosJetPackComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    Greeting()
                }
            }
        }
    }
}

@Composable
fun Greeting() {
   // var num by remember { mutableStateOf(0) }  Al girar el teléfono se iniciaría a 0,
    // sustituir remember por rememberSaveable()

    var num by rememberSaveable { mutableStateOf(0) }

    Column()
    {
        Text(text = "Contador -> $num")

        Divider(thickness = 30.dp,color = Color.Cyan)

        Sumador (
            updateCount = {
                num++
            }
        )
        Divider(thickness = 30.dp,color = Color.Red)
        Restador (
            updateCount = {
                num--
            }
        )
        Divider(thickness = 30.dp,color = Color.Green)
    }
}

@Composable
fun Sumador(
        updateCount:() -> Unit
) {
    Button(
        onClick =
        {
            updateCount()

        }
    )
    {
        Text(text = "Sumar")
    }
}

@Composable
fun Restador(
    updateCount: () -> Unit
){
    Button(
        onClick =
        {
            updateCount()
        }
    )
    {
        Text(text = "Restar")
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    EstadosJetPackComposeTheme {
        Greeting()
    }
}