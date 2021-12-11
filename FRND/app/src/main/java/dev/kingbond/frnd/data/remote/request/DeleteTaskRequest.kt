package dev.kingbond.frnd.data.remote.request


import com.google.gson.annotations.SerializedName

data class DeleteTaskRequest(
    @SerializedName("task_id")
    val taskId: Int,
    @SerializedName("user_id")
    val userId: Int
)