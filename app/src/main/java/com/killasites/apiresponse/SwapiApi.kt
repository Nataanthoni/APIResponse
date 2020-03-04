package com.killasites.apiresponse

import android.util.Base64
import com.google.gson.GsonBuilder
import com.killasites.apiresponse.network.API
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory


object SwapiApi{

   //private val AUTH = "Basic "+ Base64.encodeToString("superadminstrator@app.com:password".toByteArray(), Base64.NO_WRAP)

    private const val BASE_URL = "https://android-kotlin-fun-mars-server.appspot.com/"


    var token : String = ""

    fun Token(token: String ) {
        this.token = token
    }

     val okHttpClient = OkHttpClient
        .Builder()
        .addInterceptor { chain ->
            val original = chain.request()

            val requestBuilder = original.newBuilder()
            val finalToken = "Bearer $token"
            original.newBuilder()
                .addHeader("Authorization",finalToken)
                .build()

            val request = requestBuilder.build()
            chain.proceed(request)
        }.build()


    //Allows the late conversion of malformed Json to GSON
    val instance: API by lazy{
        val gson = GsonBuilder()
            .setLenient()
            .create()

        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(okHttpClient)
            .build()

        retrofit.create(API::class.java)


    }
}