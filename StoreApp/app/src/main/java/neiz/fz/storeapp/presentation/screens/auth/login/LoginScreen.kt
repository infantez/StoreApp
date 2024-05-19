package neiz.fz.storeapp.presentation.screens.auth.login

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import neiz.fz.storeapp.presentation.screens.auth.login.components.Login
import neiz.fz.storeapp.presentation.screens.auth.login.components.LoginContent

@Composable
fun LoginScreen(onClick: () -> Unit, onClick2: () -> Unit) {
    Scaffold (
        content = { paddingValues ->
            LoginContent(paddingValues, onClick)
            Login(onClick2)
        }
    )
}