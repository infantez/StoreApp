package neiz.fz.storeapp.presentation.screens.admin.home.components

import androidx.compose.material3.NavigationBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import neiz.fz.storeapp.navigation.screen.AdminScreen

@Composable
fun AdminBottomBar(navController: NavHostController) {
    val screens = listOf(
        AdminScreen.ProductList,
        AdminScreen.CategoryList,
        AdminScreen.Profile
    )

    val navBackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackEntry?.destination
    val bottomBarDestination = screens.any{it.route == currentDestination?.route}

    if (bottomBarDestination){
        NavigationBar (){
            screens.forEach{screen->
                if (currentDestination != null) {
                    AdminBottomBarItem(
                        screen = screen,
                        currentDestination = currentDestination,
                        navController = navController)
                }
            }
        }
    }
}