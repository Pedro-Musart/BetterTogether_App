package com.example.bettertogether.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.bettertogether.R
import com.example.bettertogether.model.Task

class AdapterTask(private val context: Context, private val tasks: MutableList<Task>): RecyclerView.Adapter<AdapterTask.TaskViewHolder>(){



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        val itemLista = LayoutInflater.from(context).inflate(R.layout.task_item,parent,false)
        val holder = TaskViewHolder(itemLista)
        return holder
    }

    override fun getItemCount(): Int = tasks.size

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        Glide.with(holder.itemView.context)
            .load(tasks[position].task_image_url)
            .placeholder(R.drawable.loading_gif) // Imagem de placeholder enquanto a imagem está sendo carregada
            .error(R.drawable.loading_gif) // Imagem a ser exibida em caso de erro no carregamento
            .diskCacheStrategy(DiskCacheStrategy.ALL) // Armazenar em cache a imagem original e as redimensionadas
            .into(holder.foto)


        holder.descricao.text = tasks[position].task_description
        holder.pontos.text = tasks[position].task_score


    }
    inner class TaskViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

        val foto = itemView.findViewById<ImageView>(R.id.fotoTask)
        val descricao = itemView.findViewById<TextView>(R.id.descTask)
        val pontos = itemView.findViewById<TextView>(R.id.pontosTask)
    }
}