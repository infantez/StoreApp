package neiz.fz.storeapp.data.datastore

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import neiz.fz.storeapp.core.Config.AUTH_KEY
import neiz.fz.storeapp.domain.model.AuthResponse

class AuthDataStore constructor (private val dataStore: DataStore<Preferences>) {

    suspend fun save(authResponse: AuthResponse){
        val dataStoreKey = stringPreferencesKey(AUTH_KEY)
        dataStore.edit { pref->
            pref[dataStoreKey] = authResponse.toJson()
        }
    }

    suspend fun delete(){
        val dataStoreKey = stringPreferencesKey(AUTH_KEY)
        dataStore.edit { pref->
            pref.remove(dataStoreKey)
        }
    }

    fun getData(): Flow<AuthResponse> {
        val dataStoreKey = stringPreferencesKey(AUTH_KEY)
        return dataStore.data.map { pref->
            if(pref[dataStoreKey] != null) {
                AuthResponse.fromJson(pref[dataStoreKey]!!)
            } else {
                AuthResponse()
            }
        }
    }

}