package neiz.fz.storeapp.navigation.graph

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import neiz.fz.storeapp.navigation.Graph
import neiz.fz.storeapp.navigation.screen.AuthScreen
import neiz.fz.storeapp.presentation.screens.admin.home.AdminHomeScreen
import neiz.fz.storeapp.presentation.screens.auth.login.LoginScreen
import neiz.fz.storeapp.presentation.screens.auth.register.RegisterScreen
import neiz.fz.storeapp.presentation.screens.client.home.ClientHomeScreen
import neiz.fz.storeapp.presentation.screens.roles.RolesScreen

fun NavGraphBuilder.AuthNavGraph(navController: NavHostController) {
    navigation(
        route = Graph.AUTH,
        startDestination = AuthScreen.Login.route
    ) {
        composable(route = AuthScreen.Login.route) {
            LoginScreen(navController)
        }
        composable(route = AuthScreen.Register.route) {
            RegisterScreen(navController)
        }
    }
}