package dev.kingbond.frnd.data.remote.request


import com.google.gson.annotations.SerializedName

data class TaskGetRequest(
    @SerializedName("user_id")
    val userId: Int
)