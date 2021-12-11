package dev.kingbond.frnd.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.kingbond.frnd.data.local.TaskDatabaseModel
import dev.kingbond.frnd.data.remote.request.CreateNewTaskRequest
import dev.kingbond.frnd.data.remote.request.DeleteTaskRequest
import dev.kingbond.frnd.data.remote.request.TaskGetRequest
import dev.kingbond.frnd.repository.TaskRepository
import javax.inject.Inject


@HiltViewModel
class TaskViewModel @Inject constructor(val repo :TaskRepository) :ViewModel(){

    fun getTaskfromRepo():LiveData<List<TaskDatabaseModel>>{
        return repo.getAllTasks()
    }

    fun saveDataToDB(taskGetRequest: TaskGetRequest){
        repo.savetoDB(taskGetRequest)
    }

    fun postToApi(createNewTaskRequest: CreateNewTaskRequest){
        repo.postTaskToApi(createNewTaskRequest)
    }

    fun deleteFromApi(deleteTaskRequest: DeleteTaskRequest){
        repo.deleteFromApi(deleteTaskRequest)
    }

    fun deleteFromDb(){
        repo.deletAll()
    }
}