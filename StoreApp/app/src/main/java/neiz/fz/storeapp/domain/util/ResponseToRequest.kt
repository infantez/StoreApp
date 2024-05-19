package neiz.fz.storeapp.domain.util

import neiz.fz.storeapp.domain.model.ErrorResponse
import retrofit2.HttpException
import retrofit2.Response
import java.io.IOException

object ResponseToRequest {
    fun <T> send(result: Response<T>): Resource<T>{
        return try {
            if(result.isSuccessful) { // 201
                Resource.Success(result.body()!!)
            }else {
                val errorResponse: ErrorResponse? = ConvertErrorBody.convert(result.errorBody())
                Resource.Failure(errorResponse?.message ?: "Error desconocido")
            }

        } catch (e: HttpException){
            // Log.d("AuthRepositoryImpl", "Error: " + e)
            e.printStackTrace()
            Resource.Failure(e.message?: "Error desconocido en la petición Http")
        }
        catch (e: IOException){
            e.printStackTrace()
            Resource.Failure(e.message?: "Verifica conexión a Internet")
        }
        catch (e: Exception){
            e.printStackTrace()
            Resource.Failure(e.message?: "Error desconocido")
        }
    }

}