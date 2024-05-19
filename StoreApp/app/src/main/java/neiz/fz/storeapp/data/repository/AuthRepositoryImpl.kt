package neiz.fz.storeapp.data.repository

import android.util.Log
import kotlinx.coroutines.flow.Flow
import neiz.fz.storeapp.data.repository.dataSource.AuthLocalDataSource
import neiz.fz.storeapp.data.repository.dataSource.AuthRemoteDataSource
import neiz.fz.storeapp.domain.model.AuthResponse
import neiz.fz.storeapp.domain.model.ErrorResponse
import neiz.fz.storeapp.domain.model.User
import neiz.fz.storeapp.domain.repository.AuthRepository
import neiz.fz.storeapp.domain.util.ConvertErrorBody
import neiz.fz.storeapp.domain.util.Resource
import neiz.fz.storeapp.domain.util.ResponseToRequest
import retrofit2.HttpException
import java.io.IOException

class AuthRepositoryImpl(
    private val authRemoteDataSource: AuthRemoteDataSource,
    private val authLocalDataSource: AuthLocalDataSource
): AuthRepository{

    override suspend fun login(email: String, password: String): Resource<AuthResponse> = ResponseToRequest.send(
        authRemoteDataSource.login(email, password)
    )

    override suspend fun register(user: User): Resource<AuthResponse> = ResponseToRequest.send(
        authRemoteDataSource.register(user)
    )

    override suspend fun saveSession(authResponse: AuthResponse) = authLocalDataSource.saveSession(authResponse)

    override fun getSessionData(): Flow<AuthResponse> = authLocalDataSource.getSessionData()

}