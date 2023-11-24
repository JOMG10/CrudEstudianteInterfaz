package com.example.crudestudiantes

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

// EstudianteAdapter.kt
class EstudianteAdapter(private val listaEstudiantes: List<Estudiante>) :
    RecyclerView.Adapter<EstudianteAdapter.EstudianteViewHolder>() {

    class EstudianteViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val txtNombre: TextView = itemView.findViewById(R.id.editTextNombre)
        val txtApellidos: TextView = itemView.findViewById(R.id.editTextApellidos)
        val txtNumeroControl: TextView = itemView.findViewById(R.id.editTextNumeroControl)
        val txtSemestre: TextView = itemView.findViewById(R.id.editTextSemestre)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EstudianteViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.fragment_second, parent, false)
        return EstudianteViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: EstudianteViewHolder, position: Int) {
        val estudiante = listaEstudiantes[position]
        holder.txtNumeroControl.text = estudiante.numeroControl
        holder.txtNombre.text = estudiante.nombre
        holder.txtApellidos.text = estudiante.apellidos
        holder.txtSemestre.text = estudiante.semestre.toString()
    }

    override fun getItemCount(): Int {
        return listaEstudiantes.size
    }
}
