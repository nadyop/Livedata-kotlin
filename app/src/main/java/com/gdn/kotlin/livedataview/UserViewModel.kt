package com.gdn.kotlin.livedataview

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel

class UserViewModel: ViewModel() {

    private lateinit var users: MutableLiveData<List<UserModel>>
    val fullName: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

    fun getUsers(): LiveData<List<UserModel>> {
        if (!::users.isInitialized) {
            loadUsers()
        }
        return users
    }

    private fun loadUsers() {
        users = MutableLiveData()
        users.value = mutableListOf(
            UserModel("adi", "boncang"),
            UserModel("ado", "bonjer"))
    }
}
