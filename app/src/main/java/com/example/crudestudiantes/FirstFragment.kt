package com.example.crudestudiantes

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [FirstFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class FirstFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private lateinit var editTextNumeroControl: EditText
    private lateinit var editTextNombre: EditText
    private lateinit var editTextApellidos: EditText
    private lateinit var editTextSemestre: EditText

    private val crudEstudiante = CRUDEstudiante()


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
         //return inflater.inflate(R.layout.fragment_first, container, false)
        /*
        editTextNumeroControl = view.findViewById(R.id.editTextNumeroControl)
        editTextNombre = view.findViewById(R.id.editTextNombre)
        editTextApellidos = view.findViewById(R.id.editTextApellidos)
        editTextSemestre = view.findViewById(R.id.editTextSemestre)


        val btnAgregarEstudiante: Button = view.findViewById(R.id.btnAgregarEstudiante)
        btnAgregarEstudiante.setOnClickListener {
            agregarEstudiante()

        }

        return view

         */
        val view = inflater.inflate(R.layout.fragment_first, container, false)

        editTextNumeroControl = view.findViewById(R.id.editTextNumeroControl)
        editTextNombre = view.findViewById(R.id.editTextNombre)
        editTextApellidos = view.findViewById(R.id.editTextApellidos)
        editTextSemestre = view.findViewById(R.id.editTextSemestre)

        val btnAgregarEstudiante: Button = view.findViewById(R.id.btnAgregarEstudiante)
        btnAgregarEstudiante.setOnClickListener {
            agregarEstudiant()
        }

        return view

    }

    private fun agregarEstudiant() {

        val numeroControl = editTextNumeroControl.text.toString()
        val nombre = editTextNombre.text.toString()
        val apellidos = editTextApellidos.text.toString()
        val semestre = editTextSemestre.text.toString().toIntOrNull()

        if (numeroControl.isNotEmpty() && nombre.isNotEmpty() && apellidos.isNotEmpty() && semestre != null ) {
            // Llamar al método CRUD en la otra clase para agregar el estudiante
            val estudiante = Estudiante(numeroControl, nombre, apellidos, semestre)
            crudEstudiante.agregarEstudiante(estudiante)
            clearFields()
            Toast.makeText(context, "Estudiante agregado correctamente" , Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(context, "Ingrese datos válidos", Toast.LENGTH_SHORT).show()
        }


    }

    private fun clearFields() {
        editTextNumeroControl.text.clear()
        editTextNombre.text.clear()
        editTextApellidos.text.clear()
        editTextSemestre.text.clear()
    }

    fun agregarEstudiante() {
        val numeroControl = editTextNumeroControl.text.toString()
        val nombre = editTextNombre.text.toString()
        val apellidos = editTextApellidos.text.toString()
        val semestre = editTextSemestre.text.toString().toIntOrNull()

        if (numeroControl.isNotEmpty() && nombre.isNotEmpty() && apellidos.isNotEmpty() && semestre != null ) {
            // Llamar al método CRUD en la otra clase para agregar el estudiante
            crudEstudiante.crearEstudiante(numeroControl,nombre, apellidos, semestre)
            Toast.makeText(context, "Estudiante agregado correctamente" + nombre + numeroControl, Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(context, "Ingrese datos válidos", Toast.LENGTH_SHORT).show()
        }
    }


    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment FirstFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            FirstFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}