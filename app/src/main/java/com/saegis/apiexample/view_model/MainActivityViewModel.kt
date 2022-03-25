package com.saegis.apiexample.view_model

import androidx.lifecycle.ViewModel
import com.saegis.apiexample.service.RetroService
import com.saegis.apiexample.service.RetrofitInstance
import com.saegis.apiexample.model.User
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivityViewModel : ViewModel() {
    fun getUserList(): List<User>? {
        val retroInstance = RetrofitInstance.getRetrofitInstance().create(RetroService::class.java)
        val call = retroInstance.getUsers()
        var users: List<User>? = null
        call.enqueue(object : Callback<List<User>?> {
            override fun onResponse(call: Call<List<User>?>, response: Response<List<User>?>) {
                users = response.body()
            }

            override fun onFailure(call: Call<List<User>?>, t: Throwable) {
                users = null
            }
        })
        return users
    }
}