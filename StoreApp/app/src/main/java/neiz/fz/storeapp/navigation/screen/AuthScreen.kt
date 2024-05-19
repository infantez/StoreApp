package neiz.fz.storeapp.navigation.screen

sealed class AuthScreen (val route: String) {

    data object Login: AuthScreen(route = "login")

    data object Register: AuthScreen(route = "register")

    data object Home: AuthScreen(route = "home")

    data object Roles: AuthScreen(route = "roles")

}