package neiz.fz.storeapp.domain.useCase.auth

import neiz.fz.storeapp.domain.repository.AuthRepository

class GetSessionDataUseCase constructor(private val repository: AuthRepository) {

    operator fun invoke() = repository.getSessionData()
}