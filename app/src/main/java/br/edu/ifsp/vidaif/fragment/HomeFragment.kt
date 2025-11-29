package br.edu.ifsp.vidaif.fragment

import android.os.Bundle
import android.os.Handler
import android.os.Looper
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
import br.edu.ifsp.vidaif.model.Banner
import br.edu.ifsp.vidaif.model.Destaque
import br.edu.ifsp.vidaif.model.Event
import br.edu.ifsp.vidaif.model.News

class HomeFragment : Fragment() {

    private var autoScrollHandler: Handler? = null
    private var autoScrollRunnable: Runnable? = null
    private var currentBannerPosition = 0

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

    override fun onDestroyView() {
        super.onDestroyView()
        // Para o auto-scroll quando a view é destruída
        stopAutoScroll()
    }

    private fun setupBannerCarousel(view: View) {
        val bannerRecyclerView: RecyclerView = view.findViewById(R.id.bannerRecyclerView)

        val layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        bannerRecyclerView.layoutManager = layoutManager

        // Lista de banners com URLs (VOCÊ PODE TROCAR AS URLs AQUI!)
        val banners = listOf(
            Banner(
                imageRes = R.drawable.banner1,
                url = "https://www.ifsp.edu.br"  // Troque pela URL desejada
            ),
            Banner(
                imageRes = R.drawable.banner2,
                url = "https://www.ifsp.edu.br/noticias"
            ),
            Banner(
                imageRes = R.drawable.banner3,
                url = "https://www.ifsp.edu.br/processos-seletivos"
            ),
            Banner(
                imageRes = R.drawable.banner4,
                url = "https://www.ifsp.edu.br/eventos"
            ),
            Banner(
                imageRes = R.drawable.banner5,
                url = "https://www.ifsp.edu.br/cursos"
            )
        )

        bannerRecyclerView.adapter = BannerAdapter(banners)

        // Configurar auto-scroll do carrossel
        startAutoScroll(bannerRecyclerView, banners.size)
    }

    private fun startAutoScroll(recyclerView: RecyclerView, itemCount: Int) {
        autoScrollHandler = Handler(Looper.getMainLooper())
        autoScrollRunnable = object : Runnable {
            override fun run() {
                if (itemCount > 0) {
                    currentBannerPosition = (currentBannerPosition + 1) % itemCount
                    recyclerView.smoothScrollToPosition(currentBannerPosition)
                    autoScrollHandler?.postDelayed(this, 3500) // Troca a cada 3.5 segundos
                }
            }
        }
        autoScrollHandler?.postDelayed(autoScrollRunnable!!, 3500)
    }

    private fun stopAutoScroll() {
        autoScrollRunnable?.let {
            autoScrollHandler?.removeCallbacks(it)
        }
        autoScrollHandler = null
        autoScrollRunnable = null
    }

    private fun setupDestaquesRecyclerView(view: View) {
        val destaquesRecyclerView: RecyclerView = view.findViewById(R.id.destaquesRecyclerView)
        destaquesRecyclerView.layoutManager = LinearLayoutManager(
            context,
            LinearLayoutManager.HORIZONTAL,
            false
        )

        // Lista de destaques com URLs (VOCÊ PODE TROCAR AS URLs AQUI!)
        val destaques = listOf(
            Destaque(
                title = "Processo Seletivo Simplificado para Vagas dos Cursos de Extensão",
                imageRes = R.drawable.destaque1,
                url = "https://www.ifsp.edu.br/processos-seletivos"  // Troque pela URL desejada
            ),
            Destaque(
                title = "IFSP abre concurso público com 21 vagas",
                imageRes = R.drawable.destaque2,
                url = "https://www.ifsp.edu.br/concursos"
            ),
            Destaque(
                title = "Processo seletivo de professor substituto",
                imageRes = R.drawable.destaque3,
                url = "https://www.ifsp.edu.br/vagas"
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