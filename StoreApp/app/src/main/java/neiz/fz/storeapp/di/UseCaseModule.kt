package neiz.fz.storeapp.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import neiz.fz.storeapp.data.repository.dataSource.AuthRemoteDataSource
import neiz.fz.storeapp.data.service.AuthService
import neiz.fz.storeapp.domain.repository.AuthRepository
import neiz.fz.storeapp.domain.useCase.auth.AuthUseCase
import neiz.fz.storeapp.domain.useCase.auth.GetSessionDataUseCase
import neiz.fz.storeapp.domain.useCase.auth.LoginUseCase
import neiz.fz.storeapp.domain.useCase.auth.LogoutUseCase
import neiz.fz.storeapp.domain.useCase.auth.RegisterUseCase
import neiz.fz.storeapp.domain.useCase.auth.SaveSessionUseCase

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Provides
    fun provideAuthUseCase(authRepository: AuthRepository) = AuthUseCase(
        login = LoginUseCase(authRepository),
        register = RegisterUseCase(authRepository),
        saveSession = SaveSessionUseCase(authRepository),
        getSessionData = GetSessionDataUseCase(authRepository),
        logout = LogoutUseCase(authRepository)
    )

}