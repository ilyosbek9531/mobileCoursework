package com.example.movielist.data.network

import com.google.gson.annotations.SerializedName

data class MyListResponse<T>(
    @SerializedName("code")
    val code: String,
    @SerializedName("status")
    val status: String,
    @SerializedName("message")
    val message: String,
    @SerializedName("data")
    val data: List<T>?
)
