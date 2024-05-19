package neiz.fz.storeapp.data.repository.dataSource

import neiz.fz.storeapp.domain.model.AuthResponse
import neiz.fz.storeapp.domain.model.User
import retrofit2.Response

interface AuthRemoteDataSource {

    suspend fun login(email: String, password: String): Response<AuthResponse>

    suspend fun register(user: User): Response<AuthResponse>
}