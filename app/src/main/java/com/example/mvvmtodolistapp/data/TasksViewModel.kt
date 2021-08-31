package com.example.mvvmtodolistapp.data

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel

@HiltViewModel
class TasksViewModel @ViewModelInject constructor(
    private val taskDAO: TaskDAO
) : ViewModel() {
}