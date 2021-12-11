package dev.kingbond.frnd.ui.recyclerview

import dev.kingbond.frnd.data.local.TaskDatabaseModel

interface ClickListener {
    fun onClick(databaseModel: TaskDatabaseModel, position: Int)
}