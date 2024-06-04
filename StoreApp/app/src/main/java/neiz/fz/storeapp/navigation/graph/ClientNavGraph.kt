package neiz.fz.storeapp.navigation.graph

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import neiz.fz.storeapp.navigation.Graph
import neiz.fz.storeapp.navigation.screen.ClientScreen
import neiz.fz.storeapp.presentation.screens.client.category.list.ClientCategoryListScreen
import neiz.fz.storeapp.presentation.screens.client.product.list.ClientProductListScreen
import neiz.fz.storeapp.presentation.screens.profile.ProfileScreen

@Composable
fun ClientNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        route = Graph.CLIENT,
        startDestination = ClientScreen.ProductList.route
    ) {
        composable(route = ClientScreen.ProductList.route){
            ClientProductListScreen()
        }
        composable(route = ClientScreen.CategoryList.route){
            ClientCategoryListScreen()
        }
        composable(route = ClientScreen.Profile.route){
            ProfileScreen()
        }

    }
}