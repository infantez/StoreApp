package neiz.fz.storeapp.navigation.graph

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import neiz.fz.storeapp.navigation.Graph
import neiz.fz.storeapp.navigation.screen.AdminScreen
import neiz.fz.storeapp.presentation.screens.admin.category.list.AdminCategoryListScreen
import neiz.fz.storeapp.presentation.screens.admin.product.list.AdminProductListScreen
import neiz.fz.storeapp.presentation.screens.profile.ProfileScreen

@Composable
fun AdminNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        route = Graph.ADMIN,
        startDestination = AdminScreen.ProductList.route
    ) {
        composable(route = AdminScreen.ProductList.route){
            AdminProductListScreen()
        }
        composable(route = AdminScreen.CategoryList.route){
            AdminCategoryListScreen()
        }
        composable(route = AdminScreen.Profile.route){
            ProfileScreen()
        }

    }
}