package neiz.fz.storeapp.navigation.screen

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.ui.graphics.vector.ImageVector

sealed class AdminScreen (
    val route: String,
    val title: String,
    val icon: ImageVector
) {

    data object CategoryList: AdminScreen(
        route = "admin/category/list",
        title = "Categorias",
        icon = Icons.Default.List
    )

    data object ProductList: AdminScreen(
        route = "admin/product/list",
        title = "Productos",
        icon = Icons.Default.ThumbUp
    )

    data object Profile: AdminScreen(
        route = "admin/profile",
        title = "Perfil",
        icon = Icons.Default.Person
    )

}