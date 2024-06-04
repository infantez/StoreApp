package neiz.fz.storeapp.presentation.screens.auth.register

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import neiz.fz.storeapp.navigation.screen.AuthScreen
import neiz.fz.storeapp.presentation.components.TopAppBarComponent
import neiz.fz.storeapp.presentation.screens.auth.register.components.Register
import neiz.fz.storeapp.presentation.screens.auth.register.components.RegisterContent

@Composable
fun RegisterScreen(navController: NavHostController) {

    Scaffold(
        topBar = {
            TopAppBarComponent(
                title = "Registro",
                upAvailable = true,
                navController = navController
            )
        },
        content = { paddingValues->
                RegisterContent(paddingValues = paddingValues)
                Register(navController)
        }
    )

}
