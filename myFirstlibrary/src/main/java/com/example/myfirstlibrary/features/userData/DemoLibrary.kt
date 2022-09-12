package com.example.myfirstlibrary.features.userData

import android.util.Log
import com.example.myfirstlibrary.features.shared.model.User
import retrofit2.Response

class DemoLibrary(var data:(value:String)->Unit) : UserView{

    private var presenterNew :UserPresenter?=null
    fun demo( ) {
//        val data =
            presenterNew= UserPresenter(this)
        presenterNew?.getUserProfile()
//        return data.toString()
    }

    override fun getData(profile: Response<List<User>>) {
        Log.e("data", profile.body()?.get(0)?.name + "\n")
        data(profile.body()?.get(0)?.name?:"")
    }

    override fun showErrorView(throwable: Throwable, function: () -> Unit) {
        Log.e("data", throwable.localizedMessage + "\n")
    }
}