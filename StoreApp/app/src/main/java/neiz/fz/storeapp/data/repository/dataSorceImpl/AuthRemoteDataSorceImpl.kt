package neiz.fz.storeapp.data.repository.dataSorceImpl

import neiz.fz.storeapp.data.repository.dataSource.AuthRemoteDataSource
import neiz.fz.storeapp.data.service.AuthService
import neiz.fz.storeapp.domain.model.AuthResponse
import neiz.fz.storeapp.domain.model.User
import retrofit2.Response

class AuthRemoteDataSourceImpl(private val authService: AuthService) : AuthRemoteDataSource {

    override suspend fun login(email: String, password: String) = authService.login(email, password)
    override suspend fun register(user: User): Response<AuthResponse> = authService.register(user)

}