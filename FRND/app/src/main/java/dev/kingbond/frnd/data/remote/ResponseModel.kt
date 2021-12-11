package dev.kingbond.frnd.data.remote


import com.google.gson.annotations.SerializedName

data class ResponseModel(
    @SerializedName("tasks")
    val tasks: List<Task>
)