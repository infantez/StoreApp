package neiz.fz.storeapp.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import neiz.fz.storeapp.data.repository.AuthRepositoryImpl
import neiz.fz.storeapp.data.repository.dataSource.AuthLocalDataSource
import neiz.fz.storeapp.data.repository.dataSource.AuthRemoteDataSource
import neiz.fz.storeapp.data.service.AuthService
import neiz.fz.storeapp.domain.repository.AuthRepository

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    fun provideAuthRepository(
        authRemoteDataSource: AuthRemoteDataSource,
        authLocalDataSource: AuthLocalDataSource
    ) : AuthRepository = AuthRepositoryImpl(authRemoteDataSource, authLocalDataSource)

}