package neiz.fz.storeapp.presentation.screens.profile

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import neiz.fz.storeapp.presentation.screens.profile.components.ProfileContent

@Composable
fun ProfileScreen() {
    Scaffold {paddingValues->
        ProfileContent(paddingValues = paddingValues)
    }
}