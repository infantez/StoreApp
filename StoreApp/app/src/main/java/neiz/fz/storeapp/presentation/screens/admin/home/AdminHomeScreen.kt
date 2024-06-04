package neiz.fz.storeapp.presentation.screens.admin.home

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import neiz.fz.storeapp.navigation.graph.AdminNavGraph
import neiz.fz.storeapp.presentation.screens.admin.home.components.AdminBottomBar

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun AdminHomeScreen(navController: NavHostController = rememberNavController()) {
    Scaffold(
        bottomBar = { AdminBottomBar(navController = navController)}
    ) { paddingValues ->
       AdminNavGraph(navController = navController)
    }
}