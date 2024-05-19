package neiz.fz.storeapp.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import neiz.fz.storeapp.data.datastore.AuthDataStore
import neiz.fz.storeapp.data.repository.dataSorceImpl.AuthLocalDataSourceImpl
import neiz.fz.storeapp.data.repository.dataSorceImpl.AuthRemoteDataSourceImpl
import neiz.fz.storeapp.data.repository.dataSource.AuthLocalDataSource
import neiz.fz.storeapp.data.repository.dataSource.AuthRemoteDataSource
import neiz.fz.storeapp.data.service.AuthService

@Module
@InstallIn(SingletonComponent::class)
object LocalDataModule {

    @Provides
    fun provideAuthLocalDataSource(authDataStore: AuthDataStore) : AuthLocalDataSource = AuthLocalDataSourceImpl(authDataStore)

}