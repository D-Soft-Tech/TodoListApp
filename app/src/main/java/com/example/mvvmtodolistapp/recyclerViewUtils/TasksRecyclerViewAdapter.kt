package com.example.mvvmtodolistapp.recyclerViewUtils

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvmtodolistapp.data.TaskDataClass
import com.example.mvvmtodolistapp.data.TodoItemClickListener
import com.example.mvvmtodolistapp.databinding.TodoItemBinding

class TasksRecyclerViewAdapter(
    val clickListener: TodoItemClickListener
) : RecyclerView.Adapter<TasksRecyclerViewViewHolder>() {
    private var listOfTodos: List<TaskDataClass> = arrayListOf()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TasksRecyclerViewViewHolder =
        TasksRecyclerViewViewHolder(
            TodoItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: TasksRecyclerViewViewHolder, position: Int) {
        holder.apply {
            if (listOfTodos[position].importance) priorityIcon.visibility = View.VISIBLE
            todoName.text = listOfTodos[position].task
            todoName.setOnClickListener {
                clickListener.todoNameClickListenerToGoToUpdate(listOfTodos[position])
            }
        }
    }

    override fun getItemCount() = listOfTodos.size

    fun setData(newTodos: List<TaskDataClass>) {
        val diff = TasksRVDiffUtil(listOfTodos, newTodos)
        val diffResult = DiffUtil.calculateDiff(diff)
        listOfTodos = newTodos
        diffResult.dispatchUpdatesTo(this)
    }
}
