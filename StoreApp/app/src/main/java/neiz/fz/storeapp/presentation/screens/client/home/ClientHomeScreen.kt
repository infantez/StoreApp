package neiz.fz.storeapp.presentation.screens.client.home

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import neiz.fz.storeapp.navigation.graph.ClientNavGraph
import neiz.fz.storeapp.presentation.screens.client.home.components.ClientBottomBar

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ClientHomeScreen(navController: NavHostController = rememberNavController()) {
    Scaffold(
        bottomBar = { ClientBottomBar(navController = navController)}
    ) {paddingValues ->
        // Box(modifier = Modifier.padding(paddingValues))
        ClientNavGraph(navController = navController)
    }
}