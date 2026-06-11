package com.example.myapp.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapp.data.UserDao
import com.example.myapp.ui.theme.Purple40
import kotlinx.coroutines.launch


@Composable
fun LoginScreen(
    userDao: UserDao,
    onLogin: () -> Unit,
    onRegisterClick: () -> Unit
) {

    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    val scope = rememberCoroutineScope ()

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


        Button(onClick = {
            scope.launch{
                val user = userDao.login(
                    email,
                    password
                )
                if(user !=null){
                    onLogin()
                }
            }
        } ,
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