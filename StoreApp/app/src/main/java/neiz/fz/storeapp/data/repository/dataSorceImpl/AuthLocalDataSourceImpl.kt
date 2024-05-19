package neiz.fz.storeapp.data.repository.dataSorceImpl

import kotlinx.coroutines.flow.Flow
import neiz.fz.storeapp.data.datastore.AuthDataStore
import neiz.fz.storeapp.data.repository.dataSource.AuthLocalDataSource
import neiz.fz.storeapp.domain.model.AuthResponse

class AuthLocalDataSourceImpl constructor(private val authDataStore: AuthDataStore): AuthLocalDataSource {
    override suspend fun saveSession(authResponse: AuthResponse) = authDataStore.saveUser(authResponse)

    override fun getSessionData(): Flow<AuthResponse> = authDataStore.getData()

}