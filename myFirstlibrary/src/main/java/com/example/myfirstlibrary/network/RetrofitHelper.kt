package com.example.myfirstlibrary.network

import com.google.gson.GsonBuilder
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * Created by prajwal on 11/4/20.
 */

object RetrofitHelper {
    private var apiService: ApiService? = null

    private var fileUploadApiService: ApiService? = null

    private val gsonConverter = GsonConverterFactory.create(GsonBuilder().setLenient().create())

    private val loggingInterceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    private val retrofit: Retrofit = Retrofit.Builder()
        .addConverterFactory(gsonConverter)
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .baseUrl("https://5e510330f2c0d300147c034c.mockapi.io/")
        .client(getOkHttpClient())
        .build()



    private fun getOkHttpClient(): OkHttpClient {
        val okHttpClient = OkHttpClient.Builder()
            .readTimeout(1, TimeUnit.MINUTES)
            .writeTimeout(1, TimeUnit.MINUTES)
        return okHttpClient.build()
    }

    fun getApiService(): ApiService {
        if (apiService == null) {
            apiService = retrofit.create(ApiService::class.java)
        }
        return apiService ?: retrofit.create(ApiService::class.java)
    }
}