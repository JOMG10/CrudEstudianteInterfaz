package com.example.crudestudiantes

import android.util.Log


class CRUDEstudiante {
    private val listaEstudiantes = mutableListOf<Estudiante>()

    fun crearEstudiante(numeroControl: String, nombre: String, apellidos: String, semestre: Int) {
        val estudiante = Estudiante(numeroControl, nombre, apellidos, semestre)

        listaEstudiantes.add(estudiante)
        Log.d("CRUDEstudiante", "Estudiante agregado: $estudiante")
        Log.d("CRUDEstudiante", "Lista de estudiantes después de agregar: $listaEstudiantes")
        println("Estudiante agregado correctamente desde la clase crud!!")


    }

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
                return "Número de control: ${estudiante.numeroControl}, Nombre: ${estudiante.nombre}, Apellidos: ${estudiante.apellidos}, Semestre: ${estudiante.semestre}"
            }
        }
        return "Estudiante no encontrado."
    }

    fun obtenerListaEstudiantes(): List<Estudiante> {
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



