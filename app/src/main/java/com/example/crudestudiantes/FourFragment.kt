package com.example.crudestudiantes

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
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
        editTextNumeroControl = view.findViewById(R.id.editarNumeroControl)
        editTextNombre = view.findViewById(R.id.editarNombre)
        editTextApellidos = view.findViewById(R.id.editarApellidos)
        editTextSemestre = view.findViewById(R.id.editarSemestre)

        val btnAgregarEstudiante: Button = view.findViewById(R.id.btnBuscarEstudianteEdit)
        btnAgregarEstudiante.setOnClickListener {
            buscarEstudianteEditar()
        }

        return view

    }



    fun buscarEstudianteEditar() {

        val crudEstudiante = (activity as MainActivity).crudEstudiante

        val numeroControl = buscarEstudianteEditar.text.toString()

        val estudiante = crudEstudiante.editar(numeroControl)

        if (estudiante != null) {

            editTextNumeroControl.setText(estudiante.numeroControl)
            editTextNombre.setText(estudiante.nombre)
            editTextApellidos.setText(estudiante.apellidos)
            editTextSemestre.setText(estudiante.semestre)

            editTextNumeroControl.isEnabled = false // Para deshabilitar la edición del número de control


            val btnEditarEstudiante: Button? = view?.findViewById(R.id.btnEditarEstudiante)
            btnEditarEstudiante?.setOnClickListener {

                val nuevoControl = editTextNumeroControl.text.toString()
                val nuevoNombre = editTextNombre.text.toString()
                val nuevoApellido = editTextApellidos.text.toString()
                val nuevoSemestre = editTextSemestre.text.toString()

                print("entrando al boton de actualizar")
                Log.d("datos_: $nuevoControl, $nuevoNombre, $nuevoApellido, $nuevoSemestre" ,"datos nuevos")
                actualizarDatos(nuevoControl, nuevoNombre, nuevoApellido, nuevoSemestre)
                clearFields()
            }

        }
    }

    fun actualizarDatos(
        nuevoControl: String,
        nuevoNombre: String,
        nuevoApellido: String,
        semestre: String
    ) {
        val crudEstudiante = (activity as MainActivity).crudEstudiante

        val edicionExitosa = crudEstudiante.editarEstudiantes(nuevoControl, nuevoNombre, nuevoApellido, semestre)

        if(edicionExitosa){
            Toast.makeText(activity, "Estudiante editado correctamente.$edicionExitosa", Toast.LENGTH_SHORT).show()
            clearFields()
        }else{
            Toast.makeText(activity, "fallo la edicion", Toast.LENGTH_SHORT).show()
            clearFields()
        }
    }


    private fun clearFields() {
        buscarEstudianteEditar.text.clear()
        editTextNumeroControl.text.clear()
        editTextNombre.text.clear()
        editTextApellidos.text.clear()
        editTextSemestre.text.clear()
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


