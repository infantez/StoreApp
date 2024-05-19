package neiz.fz.storeapp.domain.util

import android.util.Log
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import neiz.fz.storeapp.domain.model.ErrorResponse
import okhttp3.ResponseBody

object ConvertErrorBody {

    fun convert(errorBody: ResponseBody?) : ErrorResponse? {
        return try {
            errorBody?.source()?.let {
                val moshi = Moshi.Builder().addLast(KotlinJsonAdapterFactory()).build()
                val moshiAdapter = moshi.adapter(ErrorResponse::class.java)
                moshiAdapter.fromJson(it)
            }
        } catch (e: Exception){
            Log.d("convertErrorBody", "Error: " + e.message)
            null
        }
    }

}