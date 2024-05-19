package neiz.fz.storeapp.presentation.screens.auth.register

import android.util.Patterns
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import neiz.fz.storeapp.domain.model.AuthResponse
import neiz.fz.storeapp.domain.model.User
import neiz.fz.storeapp.domain.useCase.auth.AuthUseCase
import neiz.fz.storeapp.domain.useCase.auth.RegisterUseCase
import neiz.fz.storeapp.domain.util.Resource
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(private val authUseCase: AuthUseCase ): ViewModel() {

    var state by mutableStateOf(RegisterState())
        private set

    var errorMessage by mutableStateOf("")
        // private set

    var registerResponse by mutableStateOf<Resource<AuthResponse>?>(null)
        private set

    fun saveSession(authResponse: AuthResponse) = viewModelScope.launch {
        authUseCase.saveSession(authResponse)
    }

    fun register() = viewModelScope.launch {
        if(isValidForm()){
            val user = User(
                name = state.name,
                lastname = state.lastName,
                phone = state.phone,
                email = state.email,
                password = state.password
            )
            registerResponse = Resource.Loading
            val result = authUseCase.register(user)
            registerResponse = result // DATA | ERROR
        }
    }

    fun onNameInput(input: String){
        state = state.copy(name = input)
    }

    fun onLastNameInput(input: String){
        state = state.copy(lastName = input)
    }

    fun onEmailInput(input: String){
        state = state.copy(email = input)
    }

    fun onPhoneInput(input: String){
        state = state.copy(phone = input)
    }

    fun onPasswordInput(input: String){
        state = state.copy(password = input)
    }

    fun onConfirmPasswordInput(input: String){
        state = state.copy(confirmPassword = input)
    }

    fun isValidForm(): Boolean {

        if(state.name == ""){
            errorMessage = "El nombre no es válido"
            return false
        }

        else if(state.lastName == ""){
            errorMessage = "Los apellidos no son válidos"
            return false
        }

        else if(state.email == ""){
            errorMessage = "El correo no es válido"
            return false
        }

        else if(state.phone.length < 10){
            errorMessage = "El teléfono no es válido"
            return false
        }

        else if(!Patterns.EMAIL_ADDRESS.matcher(state.email).matches()){
            errorMessage = "El correo no es válido"
            return false
        }

        else if(state.password.length < 6){
            errorMessage = "La contraseña debe ser mayor a seis carácteres"
            return false
        }

        else if(state.password != state.confirmPassword){
            errorMessage = "Las contraseñas no coinciden"
            return false
        }

        return true
    }

}