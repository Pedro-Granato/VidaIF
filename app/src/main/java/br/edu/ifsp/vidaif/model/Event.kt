package br.edu.ifsp.vidaif.model

data class Event(
    val title: String,
    val date: String? = null,
    val content: String,
    val badge: String
)