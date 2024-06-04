package neiz.fz.storeapp.presentation.screens.profile

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import neiz.fz.storeapp.domain.useCase.auth.AuthUseCase
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(private val authUseCase: AuthUseCase): ViewModel(){
    fun logout() = viewModelScope.launch {
        authUseCase.logout()
    }
}