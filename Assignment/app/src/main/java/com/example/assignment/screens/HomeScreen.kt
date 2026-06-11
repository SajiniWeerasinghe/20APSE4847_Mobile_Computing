package com.example.assignment.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.assignment.ui.theme.Purple40

@Composable
fun HomeScreen(username: String, onLogout: () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFD0BCFF)),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Text(
                text = "Welcome, $username!",
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp,
                color = Purple40
            )

            Button(
                onClick = onLogout,
                shape = RoundedCornerShape(12.dp),
                modifier = Modifier.width(200.dp).height(50.dp)
            ) {
                Text("Logout")
            }
        }
    }
}