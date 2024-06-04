package neiz.fz.storeapp.navigation.screen

sealed class RolesScreen (val route: String) {

    data object Roles: RolesScreen(route = "roles")


}