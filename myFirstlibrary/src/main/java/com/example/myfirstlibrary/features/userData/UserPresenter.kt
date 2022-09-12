package com.example.myfirstlibrary.features.userData

import io.reactivex.disposables.CompositeDisposable

class UserPresenter(var view: UserView) {
    private var userInteractor: UserInteractor? = UserInteractor()
    protected var compositeDisposable: CompositeDisposable? = null

    fun getUserProfile() {
        userInteractor?.getUser()
                ?.subscribe({ profile ->
                    view.getData(profile)
                }, { throwable ->
                    view.showErrorView(throwable) {}
                })?.let { compositeDisposable?.add(it) }

    }
}