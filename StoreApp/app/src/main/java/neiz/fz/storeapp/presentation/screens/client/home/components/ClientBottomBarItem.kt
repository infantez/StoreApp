package neiz.fz.storeapp.presentation.screens.client.home.components

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import neiz.fz.storeapp.navigation.screen.ClientScreen
import neiz.fz.storeapp.presentation.components.TopAppBarComponent

@Composable
fun RowScope.ClientBottomBarItem(
    screen: ClientScreen,
    currentDestination: NavDestination,
    navController: NavHostController
) {
    NavigationBarItem(
        label = {
            Text(text = screen.title)
        },
        icon = {
            Icon(imageVector = screen.icon, contentDescription = "")
        },
        selected = currentDestination.hierarchy?.any{
            it.route == screen.route
        } == true,
        onClick = {
            navController.navigate(route = screen.route){
                popUpTo(navController.graph.findStartDestination().id)
            }
        }
        // unselectedContentColor =
    )
}