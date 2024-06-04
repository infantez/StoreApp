package neiz.fz.storeapp.presentation.screens.profile.components

import android.app.Activity
import android.content.Intent
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import neiz.fz.storeapp.navigation.Graph
import neiz.fz.storeapp.presentation.MainActivity
import neiz.fz.storeapp.presentation.components.ButtonComponent
import neiz.fz.storeapp.presentation.screens.profile.ProfileViewModel

@Composable
fun ProfileContent(paddingValues: PaddingValues, vm: ProfileViewModel = hiltViewModel()) {

    val activity = LocalContext.current as? Activity

    ButtonComponent(
        modifier = Modifier.padding(paddingValues),
        text = "Cerrar sesión",
        onClick = {
            vm.logout()
            activity?.finish()
            activity?.startActivity(Intent(activity, MainActivity::class.java))
        },
        iconDescription = "",
        style = TextStyle(
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold)
    )
}