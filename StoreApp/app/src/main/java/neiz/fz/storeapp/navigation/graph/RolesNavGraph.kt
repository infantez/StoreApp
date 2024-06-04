package neiz.fz.storeapp.navigation.graph

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import neiz.fz.storeapp.navigation.Graph
import neiz.fz.storeapp.navigation.screen.AuthScreen
import neiz.fz.storeapp.navigation.screen.RolesScreen
import neiz.fz.storeapp.presentation.screens.admin.home.AdminHomeScreen
import neiz.fz.storeapp.presentation.screens.auth.login.LoginScreen
import neiz.fz.storeapp.presentation.screens.auth.register.RegisterScreen
import neiz.fz.storeapp.presentation.screens.client.home.ClientHomeScreen
import neiz.fz.storeapp.presentation.screens.roles.RolesScreen

fun NavGraphBuilder.RolesNavGraph(navController: NavHostController) {
    navigation(
        route = Graph.ROLES,
        startDestination = RolesScreen.Roles.route
    ) {

        composable(route = RolesScreen.Roles.route) {
            RolesScreen(navController)
        }

        composable(route = Graph.CLIENT){
            ClientHomeScreen()
        }

        composable(route = Graph.ADMIN){
            AdminHomeScreen()
        }
    }
}