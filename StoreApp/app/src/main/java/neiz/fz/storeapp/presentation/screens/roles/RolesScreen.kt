package neiz.fz.storeapp.presentation.screens.roles

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import neiz.fz.storeapp.presentation.screens.roles.components.RolesContent

@Composable
fun RolesScreen() {
    Scaffold {paddingValues->
        RolesContent(paddingValues)
    }
}