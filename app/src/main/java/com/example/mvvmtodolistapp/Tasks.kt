package com.example.mvvmtodolistapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvmtodolistapp.databinding.FragmentTasksBinding
import com.google.android.material.floatingactionbutton.FloatingActionButton

class Tasks : Fragment() {
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

        // View initialization
        addFab = binding.addTaskBtn
        tasksRV = binding.tasksRv

        // Set OnClick Listener on the fab to navigate to the add screen
        addFab.setOnClickListener {
//            findNavController().navigate()
        }

        return view
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}
