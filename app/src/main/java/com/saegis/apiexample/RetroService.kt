package com.saegis.apiexample

import com.saegis.apiexample.model.User
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST

interface RetroService {

    @GET("users")
    @Headers("Accept:application/json", "Content-Type:application/json")
    fun getUsers(): Call<List<User>>

    @GET(value = "users{user_id}")
    @Headers("Accept:application/json", "Content-Type:application/json")
    fun getUserById(): Call<User>

    @POST
    @Headers(
        "Content-Type:application/json",
        "Accept:application/json",
        "Authorization: Bearer 307969131fd402ac939909ef9188a41b3ab756f1d2a3475f026b64ed337a37bd"
    )
    fun createNewUser(@Body params: User)
}