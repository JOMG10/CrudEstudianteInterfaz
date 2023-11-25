package com.example.crudestudiantes

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [SecondFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SecondFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null


    private val crudEstudiante = CRUDEstudiante()
    private lateinit var txtEstudiantes: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

       val view = inflater.inflate(R.layout.fragment_second, container, false)

        val btnListarEstudiantes = view.findViewById<Button>(R.id.btnListarEstudiantes)
        btnListarEstudiantes?.setOnClickListener { listarEstudiantes() }

        //txtEstudiantes = view.findViewById(R.id.txtEstudiantes)
        return view
    }


    private fun listarEstudiantes() {
        val estudiantes = crudEstudiante.listarEstudiantes()
        val textViewEstudiantes = view?.findViewById<TextView>(R.id.txtEstudiantes)
        textViewEstudiantes?.text = ""
        for (estudiante in estudiantes) {
            textViewEstudiantes?.append(
                "ID: ${estudiante.numeroControl}, Nombre: ${estudiante.nombre}, Apellidos: ${estudiante.apellidos}, Semestre: ${estudiante.semestre}\n"
            )
        }
    }


    @SuppressLint("SetTextI18n")
    fun mostrarLista(view: View) {
        Log.d("SecondFragment", "mostrarLista() llamado")
        val listaEstudiantes = crudEstudiante.obtenerListaEstudiantes()

        if (listaEstudiantes.isNotEmpty()) {
            val stringBuilder = StringBuilder()

            for (estudiante in listaEstudiantes) {
                stringBuilder.append("${estudiante.nombre} ${estudiante.apellidos}, Semestre ${estudiante.semestre}\n")
            }

            txtEstudiantes.text = stringBuilder.toString()
        } else {
            txtEstudiantes.text = "La lista de estudiantes está vacía."
        }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment SecondFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            SecondFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}