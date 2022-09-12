package com.example.myfirstlibrary.features.shared.repository

import android.annotation.SuppressLint
import com.example.myfirstlibrary.features.shared.model.User
import com.example.myfirstlibrary.network.RetrofitHelper
import com.example.myfirstlibrary.utils.extensions.getSubscription
import io.reactivex.Single
import io.reactivex.internal.util.NotificationLite.getError
import retrofit2.Response

object UserRepository {
     val apiService = RetrofitHelper.getApiService()

    @SuppressLint("CheckResult")
    fun getUser(): Single<Response<List<User>>> = Single.create { e ->
        apiService.userCall()
            .getSubscription()
            ?.subscribe({  response ->
                if (response.isSuccessful) {
                    e.onSuccess(response)
                } else {
                    e.onError(getError(response.code()))
                }
            }, {
                e.onError(it)
            })
    }
}