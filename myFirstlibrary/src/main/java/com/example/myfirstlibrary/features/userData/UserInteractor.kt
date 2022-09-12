package com.example.myfirstlibrary.features.userData

import com.example.myfirstlibrary.features.shared.repository.UserRepository

class UserInteractor {
    fun getUser() = UserRepository.getUser()

}