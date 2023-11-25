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

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

//        val textView: TextView = binding.textHome
//        homeViewModel.text.observe(viewLifecycleOwner) {
//            textView.text = it

//        }
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView_tasks = view.findViewById<RecyclerView>(R.id.lista_tasks)
        recyclerView_tasks.layoutManager = LinearLayoutManager(requireContext())
        recyclerView_tasks.setHasFixedSize(true)

        val listaTasks: MutableList<Task> = mutableListOf()
        //configurar o adapter
        val adapterTask = AdapterTask(requireContext(),listaTasks)
        recyclerView_tasks.adapter =  adapterTask

        val taskData = listOf(
            mapOf(
                "task_id" to 1,
                "task_name" to "task1",
                "task_image_url" to "https://th.bing.com/th/id/OIP.fh2RIEijFLZhV0AcN0ydywHaE6?rs=1&pid=ImgDetMain",
                "descricao" to "task 1",
                "pontos" to "200",
//                "company_id" to "234234234",
//                "created_at" to "2023-11-24T14:42:39.562113",
//                "updated_at" to "2023-11-24T14:42:39.562113"
            ),
            mapOf(
                "task_id" to 2,
                "task_name" to "task2",
                "task_image_url" to "https://th.bing.com/th/id/OIP.si1L4Acm3vj1_cly62xXRQHaEK?rs=1&pid=ImgDetMain",
                "task_description" to "task 2",
                "task_score" to "400",
//                "company_id" to "234234234",
//                "created_at" to "2023-11-24T14:42:39.562113",
//                "updated_at" to "2023-11-24T14:42:39.562113",

            ),

        )

        for (data in taskData) {
            val task = Task(
                id = data["task_id"] as String,  // Converte o ID para Int
//                task_name = data["task_name"] as String,
                foto = data["task_image_url"] as String,
                descricao = data["descricao"] as String,
                ponto = data["pontos"] as String,
//                company_id = data["company_id"] as String,
//                created_at = data["created_at"] as String,
//                updated_at = data["apdated_at"] as String,
//                associated_users = data["associated_users"] as List<String>
            )
            listaTasks.add(task)

    }

    fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
}

