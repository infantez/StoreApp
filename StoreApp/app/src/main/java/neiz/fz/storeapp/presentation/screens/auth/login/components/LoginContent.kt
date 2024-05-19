package neiz.fz.storeapp.presentation.screens.auth.login.components

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.ColorMatrix
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import neiz.fz.storeapp.R
import neiz.fz.storeapp.presentation.components.ButtonComponent
import neiz.fz.storeapp.presentation.components.TextFieldComponent
import neiz.fz.storeapp.presentation.screens.auth.login.LoginViewModel

@Composable
fun LoginContent(
    paddingValues: PaddingValues,
    onClick:()->Unit,
    vm:LoginViewModel = hiltViewModel()
) {

    val state = vm.state
    val context = LocalContext.current

    LaunchedEffect(key1 = vm.errorMessage){
        if(vm.errorMessage != ""){
            Toast.makeText(context, vm.errorMessage, Toast.LENGTH_SHORT).show()
            vm.errorMessage = ""
        }
    }

    Box(
        modifier = Modifier
            .padding(paddingValues = paddingValues)
            .fillMaxSize()
    ) {
        Image(
            modifier = Modifier.fillMaxSize(),
            painter = painterResource(id = R.drawable.banner),
            contentDescription = "Imagen de fondo",
            contentScale = ContentScale.Crop,
            colorFilter = ColorFilter.colorMatrix(ColorMatrix().apply {
                setToScale(
                    0.5f,
                    0.5f,
                    0.5f,
                    1f
                )
            })
        )

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 50.dp)
            , horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                modifier = Modifier
                    .height(100.dp)
                    .width(100.dp),
                painter = painterResource(id = R.drawable.shopping_cart_blue),
                contentDescription = "Logo"
            )

            Spacer(modifier = Modifier.padding(top = 10.dp))

            Text(
                text = "STORE APP",
                style = TextStyle(
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    fontSize = 20.sp
                )
            )

            Spacer(modifier = Modifier.weight(1f))

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(330.dp),
                shape = RoundedCornerShape(
                    topEnd = 40.dp,
                    topStart = 40.dp
                ),
                colors = CardDefaults.cardColors(
                    containerColor = Color.White.copy(alpha = 0.8f)
                )
            ) {

                Column(
                    modifier = Modifier
                        .padding(top = 30.dp, start = 20.dp, end = 20.dp)
                        .verticalScroll(rememberScrollState())
                ) {

                    Text(
                        text = "INGRESAR",
                        style = TextStyle(
                            fontWeight = FontWeight.Bold,
                            fontSize = 20.sp,
                            color = Color.Black
                        )
                    )

                    Spacer(modifier = Modifier.padding(15.dp))

                    TextFieldComponent(
                        modifier = Modifier.fillMaxWidth(),
                        value = state.email,
                        onValueChange = {text->
                            vm.onEmailInput(text)
                        },
                        label = "Correo electónico",
                        icon = Icons.Default.Email,
                        iconDescription = "Email",
                        keyboardType = KeyboardType.Email
                        /*
                        colors = TextFieldDefaults.colors(
                            focusedContainerColor = Color.Transparent,
                            unfocusedContainerColor = Color.Transparent
                        )
                        */
                    )

                    Spacer(modifier = Modifier.padding(2.dp))

                    TextFieldComponent(
                        modifier = Modifier.fillMaxWidth(),
                        value = state.password,
                        onValueChange = {text->
                            vm.onPasswordInput(text)
                        },
                        label = "Contraseña",
                        icon = Icons.Default.Lock,
                        iconDescription = "Contraseña",
                        keyboardType = KeyboardType.Password,
                        imeAction = ImeAction.Done,
                        hideText = true
                    )

                    Spacer(modifier = Modifier.padding(5.dp))

                    ButtonComponent(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(50.dp)
                        ,
                        text = "Ingresar",
                        onClick = {
                            vm.login()
                        },
                        iconDescription = "Ingresar",
                        style = TextStyle(
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold
                        )
                    )

                    Spacer(modifier = Modifier.padding(10.dp))

                    Row(
                        modifier = Modifier
                            .fillMaxWidth(), horizontalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = "¿No tienes cuenta?",
                            style = TextStyle(
                                fontWeight = FontWeight.Normal,
                                fontSize = 16.sp,
                                color = Color.Black
                            )
                        )

                        Spacer(modifier = Modifier.padding(5.dp))

                        Text(
                            modifier = Modifier.clickable {
                                onClick()
                            },
                            text = "Registrate",
                            style = TextStyle(
                                fontWeight = FontWeight.Normal,
                                fontSize = 16.sp,
                                color = Color.Magenta
                            )
                        )
                    }
                }

            }
        }
    }
}