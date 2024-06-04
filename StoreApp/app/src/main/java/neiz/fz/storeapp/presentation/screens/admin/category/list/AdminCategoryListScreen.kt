package neiz.fz.storeapp.presentation.screens.admin.category.list

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import neiz.fz.storeapp.presentation.screens.admin.category.list.components.AdminCategoryListContent


@Composable
fun AdminCategoryListScreen() {
    Scaffold {paddingValues->
        AdminCategoryListContent(paddingValues = paddingValues)
    }
}