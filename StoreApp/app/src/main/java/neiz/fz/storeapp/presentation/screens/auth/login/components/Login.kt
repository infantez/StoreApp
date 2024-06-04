package neiz.fz.storeapp.presentation.screens.auth.login.components

import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import neiz.fz.storeapp.domain.util.Resource
import neiz.fz.storeapp.navigation.Graph
import neiz.fz.storeapp.navigation.screen.AuthScreen
import neiz.fz.storeapp.navigation.screen.RolesScreen
import neiz.fz.storeapp.presentation.components.CircularProgressComponent
import neiz.fz.storeapp.presentation.screens.auth.login.LoginViewModel

@Composable
fun Login(
    navController: NavHostController,
    vm: LoginViewModel = hiltViewModel()
){

    when (val response = vm.loginResource){
        Resource.Loading -> {
            CircularProgressComponent()
        }
        is Resource.Success -> {
            vm.saveSession(response.data)
            if(response.data.user?.roles!!.size > 1){ // MAS DE UN ROL
                navController.navigate(route = Graph.ROLES) {
                    popUpTo(Graph.AUTH) { inclusive = true }
                }
            }
            else { // UN SOLO ROL
                navController.navigate(route = Graph.CLIENT) {
                    popUpTo(Graph.AUTH) { inclusive = true }
                }
            }
        }
        is Resource.Failure -> {
            Toast.makeText(LocalContext.current, response.message, Toast.LENGTH_SHORT).show()
        }

        else -> {
            if(response != null){
                Toast.makeText(LocalContext.current, "Error desconocido", Toast.LENGTH_SHORT).show()
            }
        }
    }

}