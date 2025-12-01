package br.edu.ifsp.vidaif.model

data class Banner(
    val imageRes: Int,
    val url: String = "",        // URL para ser aberta ao clicar no banner
    val category: String = ""    // Categoria/Título do banner (ex: "Notícias")
)
