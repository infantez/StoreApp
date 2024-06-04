package neiz.fz.storeapp.data.repository.dataSource

import kotlinx.coroutines.flow.Flow
import neiz.fz.storeapp.domain.model.AuthResponse

interface AuthLocalDataSource {

    suspend fun saveSession(authResponse: AuthResponse)
    suspend fun logout()
    fun getSessionData(): Flow<AuthResponse>
}