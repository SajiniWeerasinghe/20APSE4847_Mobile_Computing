package com.example.assignment.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.assignment.data.UserDao
import com.example.assignment.ui.theme.Purple40
import kotlinx.coroutines.launch

@Composable
fun LoginScreen(
    userDao: UserDao,
    onLogin: (String) -> Unit,
    onRegisterClick: () -> Unit
) {
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var errorMessage by remember { mutableStateOf("") }
    val scope = rememberCoroutineScope()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFD0BCFF))
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Login",
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp,
                color = Purple40
            )

            Spacer(modifier = Modifier.height(16.dp))

            TextField(
                value = username,
                onValueChange = { username = it },
                modifier = Modifier.fillMaxWidth(),
                label = { Text("Username") }
            )

            Spacer(modifier = Modifier.height(16.dp))

            TextField(
                value = password,
                onValueChange = { password = it },
                modifier = Modifier.fillMaxWidth(),
                label = { Text("Password") },
                visualTransformation = PasswordVisualTransformation()
            )

            Spacer(modifier = Modifier.height(8.dp))

            if (errorMessage.isNotEmpty()) {
                Text(text = errorMessage, color = Color.Red, fontSize = 14.sp)
                Spacer(modifier = Modifier.height(8.dp))
            }

            Button(
                onClick = {
                    scope.launch {
                        val user = userDao.login(username, password)
                        if (user != null) {
                            onLogin(user.username)
                        } else {
                            errorMessage = "Invalid username or password"
                        }
                    }
                },
                shape = RoundedCornerShape(12.dp),
                modifier = Modifier.fillMaxWidth().height(50.dp)
            ) {
                Text("Login")
            }

            TextButton(onClick = onRegisterClick) {
                Text("Go to Register")
            }
        }
    }
}