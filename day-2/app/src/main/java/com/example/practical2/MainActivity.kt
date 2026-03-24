package com.example.practical2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.practical2.ui.theme.Practical2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Practical2Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Sajini",
                        modifier = Modifier.padding(innerPadding)
                    )
                    BodyMsg()
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        fontSize = 24.sp,
        modifier = modifier.background(Color.Cyan)
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Practical2Theme {
        Greeting("Android")
    }
}
@Composable
fun BodyMsg(modifier: Modifier = Modifier) {
    Text(
        text = "Good Evening!",
        modifier = modifier.padding(top = 50.dp)
    )
}
@Preview(showBackground = true)  //@preview only for testing purposes
@Composable
fun BodyMsgPreview(modifier: Modifier = Modifier) {
    Text(
        text = "Good Evening!",
        modifier = modifier.padding(top = 50.dp)
    )
}