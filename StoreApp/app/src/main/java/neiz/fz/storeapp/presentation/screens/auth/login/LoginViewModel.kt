package neiz.fz.storeapp.presentation.screens.auth.login

import android.util.Log
import android.util.Patterns
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import neiz.fz.storeapp.domain.model.AuthResponse
import neiz.fz.storeapp.domain.useCase.auth.AuthUseCase
import neiz.fz.storeapp.domain.util.Resource
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(private val authUseCase: AuthUseCase): ViewModel() {

    var state by mutableStateOf(LoginState())
        private set

    var errorMessage by mutableStateOf("")
        // private set

    // LOGIN RESPONSE
    var loginResource by mutableStateOf<Resource<AuthResponse>?>(null)
        private set

    init {
        getSessionData()
    }

    fun getSessionData() = viewModelScope.launch {
        authUseCase.getSessionData().collect() {data->
            if(!data.token.isNullOrBlank()) {
               loginResource = Resource.Success(data)
            }
        }
    }

    fun saveSession(authResponse: AuthResponse) = viewModelScope.launch {
        authUseCase.saveSession(authResponse)
    }

    fun login() = viewModelScope.launch {
        if(isValidForm()){
            loginResource = Resource.Loading // ESPERANDO
            val result = authUseCase.login(state.email, state.password) // RETORNA RESPUESTA
            loginResource = result // RESULTADO
            Log.d("LoginViewModel", "Response: ${loginResource}")
        }

    }

    fun onEmailInput(email: String){
        state = state.copy(email = email)
    }

    fun onPasswordInput(password: String){
        state = state.copy(password = password)
    }

    fun isValidForm(): Boolean {
        if(!Patterns.EMAIL_ADDRESS.matcher(state.email).matches()){
            errorMessage = "El correo no es válido"
            return false
        }

        else if(state.password.length < 6){
            errorMessage = "La contraseña debe ser mayor a seis carácteres"
            return false
        }

        return true
    }

}