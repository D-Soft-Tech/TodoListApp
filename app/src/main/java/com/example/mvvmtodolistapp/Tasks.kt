package com.example.mvvmtodolistapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvmtodolistapp.data.TaskDataClass
import com.example.mvvmtodolistapp.data.TodoItemClickListener
import com.example.mvvmtodolistapp.databinding.FragmentTasksBinding
import com.google.android.material.floatingactionbutton.FloatingActionButton
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class Tasks : Fragment(), TodoItemClickListener {
    @Inject
    lateinit var rvAdapter: TodoItemClickListener
    private var _binding: FragmentTasksBinding? = null
    private val binding get() = _binding!!
    private lateinit var addFab: FloatingActionButton
    private lateinit var tasksRV: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentTasksBinding.inflate(inflater, container, false)
        val view = binding.root

        // RecyclerView Adapter

        // View initialization
        addFab = binding.addTaskBtn
        tasksRV = binding.tasksRv

        // Set OnClick Listener on the fab to navigate to the add screen
        addFab.setOnClickListener {
            findNavController().navigate(R.id.action_tasks_to_addTask)
        }

        return view
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun todoNameClickListenerToGoToUpdate(todo: TaskDataClass) {
        val action = TasksDirections.actionTasksToUpdateTaskFragment(todo)
        findNavController().navigate(action)
    }
}
