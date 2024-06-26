package neiz.fz.storeapp.di

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.PreferenceDataStoreFactory
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStoreFile
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import neiz.fz.storeapp.core.Config.AUTH_PREFERENCE
import neiz.fz.storeapp.data.datastore.AuthDataStore
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataStoreModule {

    @Provides
    @Singleton
    fun providePreferenceDataStore(@ApplicationContext context: Context): DataStore<Preferences> =
        PreferenceDataStoreFactory.create (
            produceFile = {
                context.preferencesDataStoreFile(AUTH_PREFERENCE)
            }
        )

    @Provides
    @Singleton
    fun provideAuthDataStore(dataStore: DataStore<Preferences>) = AuthDataStore(dataStore)
}