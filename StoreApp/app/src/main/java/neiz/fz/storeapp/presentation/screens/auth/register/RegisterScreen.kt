package neiz.fz.storeapp.presentation.screens.auth.register

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import neiz.fz.storeapp.navigation.screen.AuthScreen
import neiz.fz.storeapp.presentation.components.TopAppBarComponent
import neiz.fz.storeapp.presentation.screens.auth.register.components.Register
import neiz.fz.storeapp.presentation.screens.auth.register.components.RegisterContent

@Composable
fun RegisterScreen(onClick: () -> Unit, onClick2: () -> Unit) {

    Scaffold(
        topBar = {
            TopAppBarComponent(
                title = "Registro",
                upAvailable = true,
                onClick = onClick
            )
        },
        content = { paddingValues->
                RegisterContent(paddingValues)
                Register(onClick2)
        }
    )

}
