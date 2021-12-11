package dev.kingbond.frnd.repository

import androidx.lifecycle.LiveData
import dev.kingbond.frnd.data.local.TaskDao
import dev.kingbond.frnd.data.local.TaskDatabaseModel
import dev.kingbond.frnd.data.remote.request.CreateNewTaskRequest
import dev.kingbond.frnd.data.remote.request.DeleteTaskRequest
import dev.kingbond.frnd.data.remote.request.Task
import dev.kingbond.frnd.data.remote.request.TaskGetRequest
import dev.kingbond.frnd.di.TaskModule
import dev.kingbond.frnd.utils.ApiServices
import dev.kingbond.frnd.utils.ResponseHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject


class TaskRepository @Inject constructor(val taskDao: TaskDao) {

    private val api = TaskModule.getInstance().create(ApiServices::class.java)
    var responseHandler = ResponseHandler()

    fun savetoDB(createNewTaskRequest: TaskGetRequest){
        CoroutineScope(Dispatchers.IO).launch {
            val response = api.getTaskFromAPI(TaskGetRequest(1002))
            saveToDatabase(response.tasks)
        }
    }

    private fun saveToDatabase(response: List<dev.kingbond.frnd.data.remote.Task>) {
        var list = ArrayList<TaskDatabaseModel>()
        response.forEach {
            val data = TaskDatabaseModel(it.taskDetail.date,it.taskDetail.description,it.taskDetail.title,it.taskId)
            list.add(data)
        }
        taskDao.insertTaskFromAPI(list)
    }

    fun getAllTasks():LiveData<List<TaskDatabaseModel>>{
        return taskDao.getTask()
    }

    fun postTaskToApi(createNewTaskRequest: CreateNewTaskRequest){
        CoroutineScope(Dispatchers.IO).launch {
            api.createNewTaskToAPI(createNewTaskRequest)
        }
    }

    fun deleteFromApi(deleteTaskRequest: DeleteTaskRequest){
        CoroutineScope(Dispatchers.IO).launch {
            api.deleteTaskFromAPI(deleteTaskRequest)
        }
    }

    fun deletAll(){
        CoroutineScope(Dispatchers.IO).launch {
            taskDao.deleteAllDB()
        }
    }
}