package com.example.myfirstlibrary.utils.extensions

import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit

fun <T> Single<T>?.getSubscription(): Single<T>? =
    this?.subscribeOn(Schedulers.io())
        ?.observeOn(AndroidSchedulers.mainThread())

fun <T> Single<T>?.setDelay(timeInSeconds: Long = 2L): Single<T>? =
    this?.delay(timeInSeconds, TimeUnit.SECONDS)

fun <T> Single<T>?.setTimer(timeInSeconds: Long = 2L): Single<T>? =
    this?.delay(timeInSeconds, TimeUnit.SECONDS)