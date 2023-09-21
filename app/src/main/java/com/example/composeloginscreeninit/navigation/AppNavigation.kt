package com.example.composeloginscreeninit.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.composeloginscreeninit.screens.login.LoginScreen
import com.example.composeloginscreeninit.screens.register.RegisterScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = AppScreens.LoginScreen.route,
    ){

        composable(route = AppScreens.LoginScreen.route){
            LoginScreen(navController)
        }
        composable(route = AppScreens.RegisterScreen.route){
            RegisterScreen(navController)
        }
    }
}