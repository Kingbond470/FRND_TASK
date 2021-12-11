package dev.kingbond.frnd.data.remote.request


import com.google.gson.annotations.SerializedName

data class CreateNewTaskRequest(
    @SerializedName("task")
    val task: Task,
    @SerializedName("user_id")
    val userId: Int
)