package com.example.mvvmtodolistapp.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface TaskDAO {
    @Query("SELECT * FROM task_table ORDER BY importance DESC")
    fun getAllTaskFromDB(): Flow<List<TaskDataClass>>

    @Delete
    suspend fun deleteSingleTask(taskToDelete: TaskDataClass)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addTask(taskToBeAdded: TaskDataClass)

    @Update
    suspend fun updateTask(taskToBeUpdated: TaskDataClass)

    @Query("DELETE FROM task_table")
    suspend fun deleteAllTasks()
}
