package com.ihuntgore.gradesapp.view.model

import java.io.Serializable

// Serializable permite pasarlo por un bundle, es regular en terminos de rendimiento pero no importa por ahora
class Student(val name: String, val grade1: Number, val grade2: Number) : Serializable {

    // Haciendo get() se le dice que cada vez que se requiera se recalcule
    val promedio: Double
        get() = (grade1.toDouble() + grade2.toDouble()) / 2
}