package com.example.bettertogether.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.bettertogether.Adapter.AdapterTask
import com.example.bettertogether.R
import com.example.bettertogether.databinding.FragmentHomeBinding
import com.example.bettertogether.model.Task

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel = ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val recyclerView_tasks = root.findViewById<RecyclerView>(R.id.lista_tasks)
        recyclerView_tasks.layoutManager = LinearLayoutManager(requireContext())
        recyclerView_tasks.setHasFixedSize(true)

        val listaTasks: MutableList<Task> = mutableListOf()
        // Configurar o adapter
        val adapterTask = AdapterTask(requireContext(), listaTasks)
        recyclerView_tasks.adapter = adapterTask

        val taskData = listOf(
            mapOf(
                "task_id" to "1",
                "task_name" to "task1",
                "task_image_url" to "https://th.bing.com/th/id/OIP.fh2RIEijFLZhV0AcN0ydywHaE6?rs=1&pid=ImgDetMain",
                "task_description" to "task 1",
                "task_score" to "200",
                "company_id" to "234234234",
                "created_at" to "2023-11-24T14:42:39.562113",
                "updated_at" to "2023-11-24T14:42:39.562113"
            ),
            mapOf(
                "task_id" to "2",
                "task_name" to "task2",
                "task_image_url" to "https://th.bing.com/th/id/OIP.si1L4Acm3vj1_cly62xXRQHaEK?rs=1&pid=ImgDetMain",
                "task_description" to "task 2",
                "task_score" to "400",
                "company_id" to "234234234",
                "created_at" to "2023-11-24T14:42:39.562113",
                "updated_at" to "2023-11-24T14:42:39.562113",
            ),
        )

        for (data in taskData) {
            val task = Task(
                task_id = data["task_id"] as String,
                task_name = data["task_name"] as String,
                task_image_url = data["task_image_url"] as String,
                task_description = data["task_description"] as String,
                task_score = data["task_score"] as String,
                company_id = data["company_id"] as String,
                created_at = data["created_at"] as String,
                updated_at = data["updated_at"] as String?,
                associated_users = emptyList()
            )
            listaTasks.add(task)
        }

        adapterTask.notifyDataSetChanged()

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

