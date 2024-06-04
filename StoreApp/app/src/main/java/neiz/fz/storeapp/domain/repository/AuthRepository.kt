package neiz.fz.storeapp.domain.repository

import kotlinx.coroutines.flow.Flow
import neiz.fz.storeapp.domain.model.AuthResponse
import neiz.fz.storeapp.domain.model.User
import neiz.fz.storeapp.domain.util.Resource

interface AuthRepository {

    suspend fun login(email: String, password: String): Resource<AuthResponse>
    suspend fun register(user: User): Resource<AuthResponse>
    suspend fun saveSession(authResponse: AuthResponse)
    suspend fun logout()
    fun getSessionData(): Flow<AuthResponse>

}