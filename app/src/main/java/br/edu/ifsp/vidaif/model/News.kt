package br.edu.ifsp.vidaif.model

data class News(
    val title: String,
    val date: String,
    val content: String,
    val isNew: Boolean = false
)