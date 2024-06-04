package neiz.fz.storeapp.presentation.screens.auth.login

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import neiz.fz.storeapp.presentation.screens.auth.login.components.Login
import neiz.fz.storeapp.presentation.screens.auth.login.components.LoginContent

@Composable
fun LoginScreen(navController: NavHostController) {
    Scaffold (
        content = { paddingValues ->
            LoginContent(navController = navController, paddingValues)
            Login(navController = navController)
        }
    )
}