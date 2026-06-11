package com.example.myapp.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.myapp.ui.theme.Purple40

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