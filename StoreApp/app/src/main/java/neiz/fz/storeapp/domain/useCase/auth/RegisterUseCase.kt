package neiz.fz.storeapp.domain.useCase.auth

import neiz.fz.storeapp.domain.model.User
import neiz.fz.storeapp.domain.repository.AuthRepository

class RegisterUseCase(private val repository: AuthRepository){

    suspend operator fun invoke(user: User) = repository.register(user)

}
