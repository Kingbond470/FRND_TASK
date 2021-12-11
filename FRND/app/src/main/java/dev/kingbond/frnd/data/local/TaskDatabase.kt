package dev.kingbond.frnd.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [TaskDatabaseModel::class], version = 1)
abstract class TaskDatabase : RoomDatabase() {

    abstract fun getTaskDao(): TaskDao

}