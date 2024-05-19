package neiz.fz.storeapp.domain.useCase.auth

import neiz.fz.storeapp.domain.model.AuthResponse
import neiz.fz.storeapp.domain.repository.AuthRepository

class SaveSessionUseCase constructor(private val repository: AuthRepository) {
    suspend operator fun invoke(authResponse: AuthResponse) = repository.saveSession(authResponse)
}