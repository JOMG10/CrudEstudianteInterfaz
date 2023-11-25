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
 * Use the [FourFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class FourFragment() : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private lateinit var buscarEstudianteEditar: EditText
    private lateinit var editTextNumeroControl: EditText
    private lateinit var editTextNombre: EditText
    private lateinit var editTextApellidos: EditText
    private lateinit var editTextSemestre: EditText

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
        val view = inflater.inflate(R.layout.fragment_four, container, false)


        buscarEstudianteEditar = view.findViewById(R.id.BuscarEstudianteEditar)

        val btnAgregarEstudiante: Button = view.findViewById(R.id.btnBuscarEstudianteEdit)
        btnAgregarEstudiante.setOnClickListener {
            buscarEstudianteEditar()
        }

        return view

    }


    fun buscarEstudianteEditar() {
        val crudEstudiante = (activity as MainActivity).crudEstudiante

        val numeroControl = buscarEstudianteEditar.text.toString()

        // Llama al método editar de CRUDEstudiante para obtener el estudiante
        val estudiante = crudEstudiante.editar(numeroControl)

        if (estudiante != null) {
            // Asignas cada valor a los EditText correspondientes
            val nuevoControl = editTextNumeroControl.setText(estudiante.numeroControl).toString()
            val nuevoNombre =  editTextNombre.setText(estudiante.nombre).toString()
            val nuevoApellido =  editTextApellidos.setText(estudiante.apellidos).toString()
            val nuevoSemestreStr = editTextSemestre.text.toString()
            val nuevoSemestre = nuevoSemestreStr.toIntOrNull()

            //val nuevoSemestre  = editTextSemestre.setText((estudiante.semestre.toString().toIntOrNull()))

            editTextNumeroControl.isEnabled = false // Para deshabilitar la edición del número de control

            view?.let { safeView ->
                val btnAgregarEstudiante: Button = safeView.findViewById(R.id.btnEditarEstudiante)
                btnAgregarEstudiante.setOnClickListener {
                    if (nuevoSemestre != null) {
                        acrualizarDatos(nuevoControl, nuevoNombre, nuevoApellido, nuevoSemestre)
                    } else {
                        // Manejar el caso en que el texto no sea un número válido
                        Toast.makeText(activity, "El semestre ingresado no es un número válido", Toast.LENGTH_SHORT).show()
                    }
                }
            }

            // Puedes mostrar un mensaje indicando que el estudiante fue encontrado
            Toast.makeText(
                activity,
                "Estudiante encontrado. Puedes editar la información.",
                Toast.LENGTH_SHORT
            ).show()
        } else {
            // Puedes mostrar un mensaje indicando que el estudiante no fue encontrado
            Toast.makeText(activity, "Estudiante no encontrado", Toast.LENGTH_SHORT).show()
        }
    }

    fun acrualizarDatos(nuevoControl: String,nuevoNombre: String,nuevoApellido : String,nuevoSemestre: Int){

        val crudEstudiante = (activity as MainActivity).crudEstudiante
        crudEstudiante.editarEstudiantes(nuevoControl,nuevoNombre,nuevoApellido,nuevoSemestre)

    }


    fun actualizarInterfazUsuario() {
        editTextNumeroControl.setText("")
        editTextNombre.setText("")
        editTextApellidos.setText("")
        editTextSemestre.setText("")
        // Actualiza otras vistas según sea necesario
    }


    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment FourFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            FourFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}