package com.example.crudestudiantes

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [FiveFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class FiveFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private lateinit var editTextNumeroControl: EditText

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
        val view = inflater.inflate(R.layout.fragment_five, container, false)

        editTextNumeroControl = view.findViewById(R.id.txtBuscarE)
        // Inflate the layout for this fragment


        val btnAgregarEstudiante: Button = view.findViewById(R.id.btnEliminarEstudiante)
        btnAgregarEstudiante.setOnClickListener {
            buscarEstudiante()
        }

        return view
    }

    @SuppressLint("SuspiciousIndentation")
    fun buscarEstudiante(){
        val crudEstudiante = (activity as MainActivity).crudEstudiante
        val numeroControl = editTextNumeroControl.text.toString()

        val estudiante = crudEstudiante.eliminarEstudiante(numeroControl)
        val textViewEstudiantes = view?.findViewById<TextView>(R.id.txtEstudiantes)
        textViewEstudiantes?.text = ""

        textViewEstudiantes?.append(estudiante)

        clearFields()

    }

    private fun clearFields() {
        editTextNumeroControl.text.clear()
    }
    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment FiveFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            FiveFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}