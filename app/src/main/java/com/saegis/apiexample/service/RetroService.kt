package com.saegis.apiexample.service

import com.saegis.apiexample.model.User
import com.saegis.apiexample.model.UserResponse
import retrofit2.Call
import retrofit2.http.*

//https://www.youtube.com/watch?v=TJpk7ezvtGo&t=656s
//https://github.com/ravizworldz/Retrofit_PATCH_MVVM_Kotlin/tree/main/app/src/main/java/com/demo/retrofithttpmethods

interface RetroService {

    @GET("users")
    @Headers("Accept:application/json", "Content-Type:application/json")
    fun getUsers(): Call<List<User>>

    @GET("users/{user_id}")
    @Headers("Accept:application/json", "Content-Type:application/json")
    fun getUserById(@Path("user_id") userId: String): Call<User>

    @POST("users")
    @Headers(
        "Content-Type:application/json",
        "Accept:application/json",
        "Authorization: Bearer 307969131fd402ac939909ef9188a41b3ab756f1d2a3475f026b64ed337a37bd"
    )
    fun createNewUser(@Body params: User): Call<UserResponse>

    @PUT("users/{user_id}")
    @Headers(
        "Content-Type:application/json",
        "Accept:application/json",
        "Authorization: Bearer 307969131fd402ac939909ef9188a41b3ab756f1d2a3475f026b64ed337a37bd"
    )
    fun updateUser(@Path("user_id") userId: String, @Body params: User): Call<UserResponse>

    @DELETE("users/{user_id}")
    @Headers(
        "Content-Type:application/json",
        "Accept:application/json",
        "Authorization: Bearer 307969131fd402ac939909ef9188a41b3ab756f1d2a3475f026b64ed337a37bd"
    )
    fun deleteUser(@Path("user_id") userId: String): Call<UserResponse>
}