package br.edu.ifsp.vidaif.model

data class Destaque(
    val title: String,
    val imageRes: Int,
    val url: String = ""  // URL para ser aberta ao clicar no destaque
)