package com.example.mvvmtodolistapp.data

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize
import java.text.DateFormat

@Entity(tableName = "task_table")
@Parcelize
data class TaskDataClass(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val task: String,
    val importance: Boolean = false,
    val completed: Boolean = false,
    val dateCreated: Long = System.currentTimeMillis()
) : Parcelable {
    val createdDateInStringFormat get() = DateFormat.getDateTimeInstance().format(dateCreated)
}
