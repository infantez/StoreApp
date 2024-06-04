package neiz.fz.storeapp.presentation.screens.roles

import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import neiz.fz.storeapp.presentation.components.TopAppBarComponent
import neiz.fz.storeapp.presentation.screens.roles.components.RolesContent

@Composable
fun RolesScreen(navController: NavHostController) {
    Scaffold (
        topBar = {
            TopAppBarComponent(title = "Selecciona un rol")
        }
    ) {paddingValues->
        RolesContent(paddingValues, navController)
    }
}