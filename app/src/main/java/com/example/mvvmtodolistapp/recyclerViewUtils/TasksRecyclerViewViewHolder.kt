package com.example.mvvmtodolistapp.recyclerViewUtils

import androidx.recyclerview.widget.RecyclerView
import com.example.mvvmtodolistapp.databinding.TodoItemBinding

class TasksRecyclerViewViewHolder(private val binding: TodoItemBinding) :
    RecyclerView.ViewHolder(binding.root) {
    val importanceCheckBox = binding.checkBox
    val todoName = binding.todoName
    val priorityIcon = binding.priorityIcon
}
