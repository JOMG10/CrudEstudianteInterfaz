package com.example.crudestudiantes

import android.util.Log


class CRUDEstudiante {
    private val listaEstudiantes = mutableListOf<Estudiante>()

    fun crearEstudiante(numeroControl: String, nombre: String, apellidos: String, semestre: Int) {
        val estudiante = Estudiante(numeroControl, nombre, apellidos, semestre)

        listaEstudiantes.add(estudiante)
    }
    //metodo actualizado--------------------

    fun agregarEstudiante(estudiante: Estudiante) {
        listaEstudiantes.add(estudiante)
        print("accediendo ala clase crud")
        Log.d("se agrego" ,"Estudiante agregado correctamente:  $estudiante ")
    }

    fun listarEstudiantes(): List<Estudiante> {
        Log.d("se agrego" ,"retornando la lista: $listaEstudiantes")
        return listaEstudiantes.toList()

    }
    //--------------------------------------------------

    fun eliminarEstudiante(numeroControl: String): String {
        val iterador = listaEstudiantes.iterator()
        while (iterador.hasNext()) {
            val estudiante = iterador.next()
            if (estudiante.numeroControl == numeroControl) {
                iterador.remove()
                return "Estudiante eliminado correctamente."
            }
        }
        return "Estudiante no encontrado."
    }

    fun buscarEstudiante(numeroControl: String): String {
        for (estudiante in listaEstudiantes) {
            if (estudiante.numeroControl == numeroControl) {
                return  "----DATOS DEL ESTUDIANTE -----\n" +
                        "NUMERO DE CONTROL: ${estudiante.numeroControl}\n" +
                        "NOMBRE: ${estudiante.nombre}\n" +
                        " APELLIDOS: ${estudiante.apellidos}\n" +
                        " SEMESTRE: ${estudiante.semestre}\n \n "
            }
        }
        return "Estudiante no encontrado."
    }

    fun obtenerListaEstudiantes(): List<Estudiante> {
        Log.d("CRUDEstudiante", "Accediendo al metodo listar estudiantes: ")

        return listaEstudiantes.toList()
    }

    fun editarEstudiantes(numeroControl: String, nombre: String, apellidos: String, semestre: Int): String {
        for (estudiante in listaEstudiantes) {
            if (estudiante.numeroControl == numeroControl) {
                estudiante.nombre = nombre
                estudiante.apellidos = apellidos
                estudiante.semestre = semestre
                return "Estudiante editado correctamente."
            }
        }
        return "Estudiante no encontrado."
    }
}



