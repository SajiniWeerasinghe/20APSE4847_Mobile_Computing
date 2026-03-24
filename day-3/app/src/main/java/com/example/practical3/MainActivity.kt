package com.example.practical3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.practical3.ui.theme.Practical3Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Practical3Theme {
                ProfileScreen()

            }
        }
    }
}
@Composable
fun ProfileScreen(){
    Column(modifier = Modifier
        .fillMaxSize() ,
        horizontalAlignment = Alignment.CenterHorizontally)
    {
        ProfileTitle()
        ProfileImage()
        ProfileDescription()
    }

}

@Composable
fun ProfileTitle(){
    Text(
        text = "Sajini",
        modifier = Modifier.padding(16.dp)
    )
}

@Composable
fun ProfileImage(){
    Icon(
        imageVector = Icons.Default.AccountCircle,
        contentDescription = "Profile Image",
        modifier = Modifier
            .padding(16.dp)
            .size(100.dp)
    )
}

@Composable
fun ProfileDescription(){
    Text(
        text = "I am sajini weerasinghe, undergraduate at SUSL. I'm from Ratnapura",
        modifier = Modifier.padding(16.dp)
    )
}

