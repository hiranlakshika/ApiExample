package com.saegis.apiexample.view_model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.saegis.apiexample.service.RetroService
import com.saegis.apiexample.service.RetrofitInstance
import com.saegis.apiexample.model.User
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivityViewModel : ViewModel() {
    var loadUserData: MutableLiveData<List<User>?> = MutableLiveData()

    fun getLoadUserObserver(): MutableLiveData<List<User>?> {
        return loadUserData
    }

    fun getUserList() {
        val retroInstance = RetrofitInstance.getRetrofitInstance().create(RetroService::class.java)
        val call = retroInstance.getUsers()
        call.enqueue(object : Callback<List<User>?> {
            override fun onResponse(call: Call<List<User>?>, response: Response<List<User>?>) {
                loadUserData.postValue(response.body())
            }

            override fun onFailure(call: Call<List<User>?>, t: Throwable) {
                loadUserData.postValue(null)
            }
        })
    }
}