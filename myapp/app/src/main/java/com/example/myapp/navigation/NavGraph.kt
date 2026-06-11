package com.example.myapp.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.myapp.data.AppDatabase
import com.example.myapp.screen.*

@Composable
fun NavGraph(){
    val context = LocalContext.current
    val db = remember{
        androidx.room.Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "app_database"
        ).build()

    }

    val userDao = db.userDao()

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "login") {

        composable("login") {
            LoginScreen(
                 userDao,
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
                userDao,
                onComplete = { navController.popBackStack() }

            )
        }
        composable("home") {
            HomeScreen()
        }

    }
}
