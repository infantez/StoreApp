package neiz.fz.storeapp.navigation.graph

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import neiz.fz.storeapp.navigation.screen.AuthScreen
import neiz.fz.storeapp.presentation.screens.auth.login.LoginScreen
import neiz.fz.storeapp.presentation.screens.auth.register.RegisterScreen
import neiz.fz.storeapp.presentation.screens.home.HomeScreen
import neiz.fz.storeapp.presentation.screens.roles.RolesScreen

@Composable
fun NavController() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = AuthScreen.Login.route
    ){

        composable(route = AuthScreen.Login.route){
            LoginScreen(
                onClick = {
                    navController.navigate(route = AuthScreen.Register.route)
                },
                onClick2 = {
                    navController.navigate(route = AuthScreen.Home.route)
                }
            )
        }

        composable(route = AuthScreen.Register.route){
            RegisterScreen(
                onClick = {
                    navController.popBackStack()
                },
                onClick2 = {
                    navController.navigate(route = AuthScreen.Home.route)
                }
            )
        }

        composable(route = AuthScreen.Home.route){
            HomeScreen()
        }

        composable(route = AuthScreen.Roles.route){
            RolesScreen()
        }
    }

}