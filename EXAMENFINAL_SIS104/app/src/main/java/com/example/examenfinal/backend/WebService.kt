package com.example.examenfinal.backend

import retrofit2.Call
import retrofit2.http.GET

interface WebService {
    @GET("users/")
    fun getUsuarios(): Call<ApiResponse>
}
