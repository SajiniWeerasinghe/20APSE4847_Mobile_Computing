package com.example.practical3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.navigationevent.compose.*
import androidx.compose.runtime.*
import androidx.navigationevent.compose.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.isPopupLayout
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.practical3.ui.theme.Practical3Theme
import androidx.navigation.compose.composable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.motionEventSpy
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.practical3.ui.theme.PrimaryColor
import com.example.practical3.ui.theme.Purple40
import com.example.practical3.ui.theme.Purple80


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            val navController = rememberNavController()

            NavHost(navController = navController, startDestination = "login") {

                composable("login") {
                    LoginScreen(
                        onLogin = {
                            navController.navigate("home") {
                                popUpTo("login") { inclusive = true } //backstack
                            }

                        },
                        onRegisterClick = {
                            navController.navigate("register") {}

                        }
                    )
                }
                composable("register") {
                    RegisterScreen(
                        onComplete = { navController.popBackStack() }

                    )
                }
                composable("home") {
                    HomeScreen()
                }

            }
        }
    }
}

@Composable
fun LoginScreen(
    onLogin: () -> Unit,
    onRegisterClick: () -> Unit
) {

    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFD0BCFF))
    )

    Column(
        modifier = Modifier
            .fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Login",
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp,
            color = Purple40
            )

        Spacer(Modifier.padding(16.dp))
        TextField(
            value = email,
            onValueChange = { email = it },
            modifier = Modifier.fillMaxWidth(),
            label = { Text("Email") },

        )

        Spacer(Modifier.padding(16.dp))

        TextField(
            value = password,
            onValueChange = { password = it },
            modifier = Modifier.fillMaxWidth(),
            label = { Text("Password") }
        )
        Spacer(Modifier.padding(16.dp))


        Button(onClick = onLogin ,
            shape = RoundedCornerShape(12.dp),
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)


        ) {
            Text("Login")
        }

        TextButton(onClick = onRegisterClick) {
            Text("Go to Register")
        }

    }
}


@Composable
fun RegisterScreen(onComplete: () -> Unit){

    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFD0BCFF))
    )

    Column(

        modifier = Modifier
            .fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Register",
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp,
            color = Purple40
        )
        Spacer(Modifier.padding(16.dp))

        TextField(
            value = name,
            onValueChange = { name = it },
            modifier = Modifier.fillMaxWidth(),
            label = { Text("name") }
        )

        Spacer(Modifier.padding(16.dp))


        TextField(
            value = email,
            onValueChange = { email = it },
            modifier = Modifier.fillMaxWidth(),

            label = { Text("email") }
        )
        Spacer(Modifier.padding(16.dp))

        Button(onClick = onComplete,
            shape = RoundedCornerShape(12.dp),
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp) ){
            Text("Register")
        }
        TextButton(onClick = onComplete) {
            Text("Go to Login")
        }
    }

}

@Composable
fun HomeScreen(){


    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFD0BCFF)),
        contentAlignment = Alignment.Center
    ) {


        Text(
            text = "You are logged in",
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp,
            color = Purple40,
        )

    }

}





