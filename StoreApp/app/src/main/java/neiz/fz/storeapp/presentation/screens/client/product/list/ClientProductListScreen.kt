package neiz.fz.storeapp.presentation.screens.client.product.list

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import neiz.fz.storeapp.presentation.screens.client.category.list.components.ClientCategoryListContent
import neiz.fz.storeapp.presentation.screens.client.product.list.components.ClientProductListContent


@Composable
fun ClientProductListScreen() {
    Scaffold {paddingValues->
        ClientProductListContent(paddingValues = paddingValues)
    }
}