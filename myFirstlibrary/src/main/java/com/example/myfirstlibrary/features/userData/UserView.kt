package com.example.myfirstlibrary.features.userData

import com.example.myfirstlibrary.features.shared.model.User
import retrofit2.Response

interface UserView {
    fun getData(profile: Response<List<User>>)
    fun showErrorView(throwable: Throwable, function: () -> Unit)
}