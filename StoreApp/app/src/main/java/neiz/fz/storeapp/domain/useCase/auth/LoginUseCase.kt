package neiz.fz.storeapp.domain.useCase.auth

import neiz.fz.storeapp.domain.repository.AuthRepository

class LoginUseCase(private val repository: AuthRepository) {

    suspend operator fun invoke(email: String, password: String) = repository.login(email, password)

}