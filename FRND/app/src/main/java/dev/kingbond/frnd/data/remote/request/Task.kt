package dev.kingbond.frnd.data.remote.request


import com.google.gson.annotations.SerializedName

data class Task(
    @SerializedName("date")
    val date: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("title")
    val title: String
)