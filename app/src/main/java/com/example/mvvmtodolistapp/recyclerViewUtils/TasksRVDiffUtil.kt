package com.example.mvvmtodolistapp.recyclerViewUtils

import androidx.recyclerview.widget.DiffUtil
import com.example.mvvmtodolistapp.data.TaskDataClass

class TasksRVDiffUtil(
    private val oldList: List<TaskDataClass>,
    private val newList: List<TaskDataClass>
) : DiffUtil.Callback() {
    override fun getOldListSize() = oldList.size

    override fun getNewListSize() = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int) =
        oldList[oldItemPosition].id == newList[newItemPosition].id

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int) =
        when {
            oldList[oldItemPosition].task == newList[newItemPosition].task -> true
            oldList[oldItemPosition].importance == newList[newItemPosition].importance -> true
            oldList[oldItemPosition].id == newList[newItemPosition].id -> true
            oldList[oldItemPosition].createdDateInStringFormat == newList[newItemPosition].createdDateInStringFormat -> true
            else -> false
        }
}
