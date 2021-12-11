package dev.kingbond.frnd.utils

import dev.kingbond.frnd.data.remote.ResponseModel
import dev.kingbond.frnd.data.remote.request.CreateNewTaskRequest
import dev.kingbond.frnd.data.remote.request.DeleteTaskRequest
import dev.kingbond.frnd.data.remote.request.TaskGetRequest
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiServices {

    @POST("/api/getCalendarTaskLists ")
    suspend fun getTaskFromAPI(@Body getTaskRequest: TaskGetRequest): ResponseModel

    @POST(" /api/deleteCalendarTask")
    suspend fun deleteTaskFromAPI(@Body deleteTask: DeleteTaskRequest)

    @POST("/api/storeCalendarTask")
    suspend fun createNewTaskToAPI(@Body createNewTask: CreateNewTaskRequest)
}