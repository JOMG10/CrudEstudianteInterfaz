package com.example.crudestudiantes

import android.annotation.SuppressLint
import android.util.Log


class CRUDEstudiante {
    private val listaEstudiantes = mutableListOf<Estudiante>()


    fun agregarEstudiante(estudiante: Estudiante) {
        listaEstudiantes.add(estudiante)
    }

    fun listarEstudiantes(): List<Estudiante> {
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
                return  "NUMERO DE CONTROL: ${estudiante.numeroControl}\n" +
                        "NOMBRE: ${estudiante.nombre}\n" +
                        " APELLIDOS: ${estudiante.apellidos}\n" +
                        " SEMESTRE: ${estudiante.semestre}\n \n "
            }
        }
        return "Estudiante no encontrado."
    }

    @SuppressLint("LongLogTag")
    fun editar(numeroControl: String): Estudiante? {
        Log.d("accediendo al metodo editar" ,"de la clase crud")

        for (estudiante in listaEstudiantes) {
            if (estudiante.numeroControl == numeroControl) {
                // Si encuentras el estudiante, lo devuelves directamente
                return estudiante
            }
        }
        // Si no encuentras al estudiante, devuelves null
        return null
    }


    @SuppressLint("LongLogTag")
    fun editarEstudiantes(numeroControl: String, nombre: String, apellidos: String, semestre: String): Boolean {
         for (estudiante in listaEstudiantes) {
            if (estudiante.numeroControl == numeroControl) {
                estudiante.nombre = nombre
                estudiante.apellidos = apellidos
                estudiante.semestre = semestre
                return true // Edición exitosa
            }
        }
        return false // Estudiante no encontrado
    }

}
