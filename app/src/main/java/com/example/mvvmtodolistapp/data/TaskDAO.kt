package com.example.mvvmtodolistapp.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface TaskDAO {
    @Query("SELECT * FROM task_table ORDER BY importance DESC")
    fun getAllTaskFromDB(): LiveData<List<TaskDataClass>>

    @Delete
    suspend fun deleteSingleTask(taskToDelete: TaskDataClass)

    @Insert
    suspend fun addTask(taskToBeAdded: TaskDataClass)

    @Update
    suspend fun updateTask(taskToBeUpdated: TaskDataClass)

    @Query("DELETE FROM task_table")
    suspend fun deleteAllTasks()
}
