package br.edu.ifsp.vidaif.model

data class Course(
    val title: String,
    val info: String,
    val description: String,
    val features: List<String>? = null
)

data class CourseCategory(
    val categoryName: String,
    val courses: List<Course>
)