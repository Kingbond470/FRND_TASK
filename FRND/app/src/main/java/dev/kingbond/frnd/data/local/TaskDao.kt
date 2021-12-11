package dev.kingbond.frnd.data.local

import androidx.lifecycle.LiveData
import androidx.room.*
import dev.kingbond.frnd.utils.Resource

@Dao
interface TaskDao {

    @Query("select * from tasktable")
    fun getTask(): LiveData<List<TaskDatabaseModel>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTask(taskDatabaseModel: TaskDatabaseModel)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTaskFromAPI(taskDatabaseModel: List<TaskDatabaseModel>)

    @Delete
    fun deleteTask(taskDatabaseModel: TaskDatabaseModel)

    @Query("delete from tasktable")
    fun deleteAllDB()
}