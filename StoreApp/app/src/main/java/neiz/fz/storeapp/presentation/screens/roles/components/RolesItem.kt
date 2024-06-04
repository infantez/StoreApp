package neiz.fz.storeapp.presentation.screens.roles.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import neiz.fz.storeapp.domain.model.Rol
import neiz.fz.storeapp.navigation.Graph
import neiz.fz.storeapp.navigation.screen.AuthScreen

@Composable
fun RolesItem(rol: Rol, navController: NavHostController) {
    Column(
        modifier = Modifier.clickable {
            navController.navigate(route = rol.route){
                popUpTo(route = Graph.ROLES) {inclusive = true}
            }
        },
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(20.dp))
        AsyncImage(
            modifier = Modifier
                .height(150.dp)
                .width(150.dp),
            model = rol.image,
            contentDescription = ""
        )
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = rol.name.uppercase(),
            style = TextStyle(
                fontSize = 17.sp,
                fontWeight = FontWeight.Bold
            )
        )
    }

}