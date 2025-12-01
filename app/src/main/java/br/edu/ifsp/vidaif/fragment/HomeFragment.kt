package br.edu.ifsp.vidaif.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.edu.ifsp.vidaif.R
import br.edu.ifsp.vidaif.adapter.BannerAdapter
import br.edu.ifsp.vidaif.adapter.DestaqueAdapter
import br.edu.ifsp.vidaif.adapter.EventAdapter
import br.edu.ifsp.vidaif.adapter.NewsAdapter
import br.edu.ifsp.vidaif.model.Destaque
import br.edu.ifsp.vidaif.model.Event
import br.edu.ifsp.vidaif.model.News

class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupBannerCarousel(view)
        setupDestaquesRecyclerView(view)
        setupNewsRecyclerView(view)
        setupEventsRecyclerView(view)
    }

    private fun setupBannerCarousel(view: View) {
        val bannerRecyclerView: RecyclerView = view.findViewById(R.id.bannerRecyclerView)

        val layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        bannerRecyclerView.layoutManager = layoutManager

        // Lista de imagens do banner (você pode trocar essas imagens)
        val bannerImages = listOf(
            R.drawable.banner1,    // Troque aqui!
            R.drawable.banner2,
            R.drawable.banner3,
            R.drawable.banner4,
            R.drawable.banner5
        )

        bannerRecyclerView.adapter = BannerAdapter(bannerImages)
    }

    private fun setupDestaquesRecyclerView(view: View) {
        val destaquesRecyclerView: RecyclerView = view.findViewById(R.id.destaquesRecyclerView)
        destaquesRecyclerView.layoutManager = LinearLayoutManager(
            context,
            LinearLayoutManager.HORIZONTAL,
            false
        )

        val destaques = listOf(
            Destaque(
                title = "IFSP Campus Catanduva protagoniza projeto inovador de podcasts sobre temas do Enem e acerta o tema central de 2025",
                imageRes = R.drawable.destaque1  // Troque aqui!
            ),
            Destaque(
                title = "IFSP abre concurso público com 21 vagas",
                imageRes = R.drawable.destaque2  // Troque aqui!
            ),
            Destaque(
                title = "Processo seletivo de professor substituto",
                imageRes = R.drawable.destaque3  // Troque aqui!
            )
        )

        destaquesRecyclerView.adapter = DestaqueAdapter(destaques)
    }

    private fun setupNewsRecyclerView(view: View) {
        val newsRecyclerView: RecyclerView = view.findViewById(R.id.newsRecyclerView)
        newsRecyclerView.layoutManager = LinearLayoutManager(context)

        val newsList = listOf(
            News(
                title = "Inscrições Abertas - Processo Seletivo 2025",
                date = "15/06/2025",
                content = "Estão abertas as inscrições para os cursos técnicos e superiores do IFSP Catanduva. Não perca esta oportunidade!",
                isNew = true
            ),
            News(
                title = "Feira de Profissões 2025",
                date = "12/06/2025",
                content = "Conheça os cursos e oportunidades do IFSP. Evento gratuito e aberto à comunidade.",
                isNew = false
            )
        )

        newsRecyclerView.adapter = NewsAdapter(newsList)
    }

    private fun setupEventsRecyclerView(view: View) {
        val eventsRecyclerView: RecyclerView = view.findViewById(R.id.eventsRecyclerView)
        eventsRecyclerView.layoutManager = LinearLayoutManager(context)

        val eventsList = listOf(
            Event(
                title = "Maratona de Programação",
                content = "Competição de programação para estudantes do ensino médio e superior.",
                badge = "28/06"
            )
        )

        eventsRecyclerView.adapter = EventAdapter(eventsList)
    }
}