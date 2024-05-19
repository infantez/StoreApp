package neiz.fz.storeapp.presentation.screens.auth.register.components

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
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
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
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
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import neiz.fz.storeapp.R
import neiz.fz.storeapp.presentation.components.ButtonComponent
import neiz.fz.storeapp.presentation.components.TextFieldComponent
import neiz.fz.storeapp.presentation.screens.auth.register.RegisterViewModel

@Composable
fun RegisterContent(
    paddingValues: PaddingValues,
    vm: RegisterViewModel = hiltViewModel()
) {
    val state = vm.state
    val context = LocalContext.current

    LaunchedEffect(key1 = vm.errorMessage){
        if(vm.errorMessage != ""){
            Toast.makeText(context, vm.errorMessage, Toast.LENGTH_SHORT).show()
            vm.errorMessage = ""
        }
    }

    Box (
        modifier = Modifier
            .padding(paddingValues = paddingValues)
            .fillMaxSize()
    ){
        Image(
            modifier = Modifier.fillMaxSize(),
            painter = painterResource(id = R.drawable.banner_form),
            contentDescription = "",
            contentScale = ContentScale.Crop,
            colorFilter = ColorFilter.colorMatrix(
                ColorMatrix().apply{
                    setToScale(0.6f, 0.6f, 0.6f, 1f)
                }
            )
        )

        Column (
            modifier = Modifier
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Spacer(modifier = Modifier.padding(30.dp))

            Image(
                modifier = Modifier
                    .height(100.dp)
                    .width(100.dp),
                painter = painterResource(id = R.drawable.user_image),
                contentDescription = ""
            )

            Spacer(modifier = Modifier.padding(10.dp))

            Text(
                text = "SELECCIONA UNA IMÁGEN",
                style = TextStyle(
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
            )

            Spacer(modifier = Modifier.weight(1f))

            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(topStart = 40.dp, topEnd = 40.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color.White
                )
            ) {
                
                Column(
                    modifier = Modifier
                        .padding(25.dp)
                        .verticalScroll(rememberScrollState())
                ) {
                    Text(
                        text = "REGISTRARSE",
                        style = TextStyle(
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.Black
                        )
                    )

                    TextFieldComponent(
                        modifier = Modifier.fillMaxWidth(),
                        value = state.name,
                        onValueChange = {text->
                                        vm.onNameInput(text)
                        },
                        label = "Nombres",
                        icon = Icons.Default.Person,
                        keyboardType = KeyboardType.Text,
                        capitalization = KeyboardCapitalization.Words
                    )

                    TextFieldComponent(
                        modifier = Modifier.fillMaxWidth(),
                        value = state.lastName,
                        onValueChange = {text-> vm.onLastNameInput(text)},
                        label = "Apellidos",
                        icon = Icons.Outlined.Person,
                        keyboardType = KeyboardType.Text,
                        capitalization = KeyboardCapitalization.Words
                    )

                    TextFieldComponent(
                        modifier = Modifier.fillMaxWidth(),
                        value = state.email,
                        onValueChange = {text-> vm.onEmailInput(text)},
                        label = "Correo electrónico",
                        icon = Icons.Default.Email,
                        keyboardType = KeyboardType.Email
                    )

                    TextFieldComponent(
                        modifier = Modifier.fillMaxWidth(),
                        value = state.phone,
                        onValueChange = {text-> vm.onPhoneInput(text)},
                        label = "Teléfono",
                        icon = Icons.Default.Phone,
                        keyboardType = KeyboardType.Phone
                    )

                    TextFieldComponent(
                        modifier = Modifier.fillMaxWidth(),
                        value = state.password,
                        onValueChange = {text-> vm.onPasswordInput(text)},
                        label = "Contraseña",
                        icon = Icons.Default.Lock,
                        keyboardType = KeyboardType.Password,
                        hideText = true
                    )

                    TextFieldComponent(
                        modifier = Modifier.fillMaxWidth(),
                        value = state.confirmPassword,
                        onValueChange = {text-> vm.onConfirmPasswordInput(text)},
                        label = "Confirmar Contraseña",
                        icon = Icons.Outlined.Lock,
                        keyboardType = KeyboardType.Password,
                        imeAction = ImeAction.Done,
                        hideText = true
                    )

                    Spacer(modifier = Modifier.padding(top = 15.dp))

                    ButtonComponent(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(50.dp),
                        text = "CONFIRMAR",
                        onClick = { vm.register() },
                        iconDescription = "",
                        style = TextStyle(
                            fontSize = 14.sp
                        )
                    )
                }

            }
        }
    }
}