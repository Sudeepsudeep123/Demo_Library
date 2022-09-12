package com.example.myfirstlibrary.network

import com.example.myfirstlibrary.features.shared.model.User
import io.reactivex.Single
import retrofit2.Response
import retrofit2.http.*

interface ApiService {
    @GET("users")
    fun userCall(): Single<Response<List<User>>>
}