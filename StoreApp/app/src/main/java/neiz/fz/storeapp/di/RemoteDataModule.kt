package neiz.fz.storeapp.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import neiz.fz.storeapp.data.repository.dataSorceImpl.AuthRemoteDataSourceImpl
import neiz.fz.storeapp.data.repository.dataSource.AuthRemoteDataSource
import neiz.fz.storeapp.data.service.AuthService

@Module
@InstallIn(SingletonComponent::class)
object RemoteDataModule {

    @Provides
    fun provideAuthRemoteDataSource(authService: AuthService) : AuthRemoteDataSource = AuthRemoteDataSourceImpl(authService)

}