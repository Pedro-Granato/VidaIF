package br.edu.ifsp.vidaif.fragment

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
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

    // Auto-scroll para Banner
    private var bannerAutoScrollHandler: Handler? = null
    private var bannerAutoScrollRunnable: Runnable? = null
    private var currentBannerPosition = 0

    // Auto-scroll para Destaques
    private var destaquesAutoScrollHandler: Handler? = null
    private var destaquesAutoScrollRunnable: Runnable? = null
    private var currentDestaquePosition = 0

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
        stopBannerAutoScroll()
        stopDestaquesAutoScroll()
    }

    private fun setupBannerCarousel(view: View) {
        val bannerRecyclerView: RecyclerView = view.findViewById(R.id.bannerRecyclerView)

        val layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        bannerRecyclerView.layoutManager = layoutManager

        // Lista de banners com URLs (VOCÊ PODE TROCAR AS URLs AQUI!)
        val banners = listOf(
            Banner(
                imageRes = R.drawable.banner1,
                url = "https://www.ifsp.edu.br/ps2026"
            ),
            Banner(
                imageRes = R.drawable.banner2,
                url = ""  // Sem link
            ),
            Banner(
                imageRes = R.drawable.banner3,
                url = "https://www.ifsp.edu.br/images/reitoria/AssessoriaComunicacao/GuiadoEstudante/GuiaEstudante.pdf"
            ),
            Banner(
                imageRes = R.drawable.banner4,
                url = "https://www.ifsp.edu.br/component/content/article/91-assuntos/desenvolvimento-institucional/desenv-institucional/5000-suap-aprimorado-a-pesquisa-por-palavra-chave-para-encontrar-o-tipo-de-processo-gan"
            ),
            Banner(
                imageRes = R.drawable.banner5,
                url = "https://ctd.ifsp.edu.br/index.php/component/content/article/8-assuntos/359-plano-de-desenvolvimento-institucional-comissao-local-campus-catanduva"
            )
        )

        bannerRecyclerView.adapter = BannerAdapter(banners)

        // Configurar auto-scroll do carrossel de banners
        startBannerAutoScroll(bannerRecyclerView, banners.size)
    }

    private fun startBannerAutoScroll(recyclerView: RecyclerView, itemCount: Int) {
        bannerAutoScrollHandler = Handler(Looper.getMainLooper())
        bannerAutoScrollRunnable = object : Runnable {
            override fun run() {
                if (itemCount > 0) {
                    currentBannerPosition = (currentBannerPosition + 1) % itemCount
                    recyclerView.smoothScrollToPosition(currentBannerPosition)
                    bannerAutoScrollHandler?.postDelayed(this, 3500) // Troca a cada 3.5 segundos
                }
            }
        }
        bannerAutoScrollHandler?.postDelayed(bannerAutoScrollRunnable!!, 3500)
    }

    private fun stopBannerAutoScroll() {
        bannerAutoScrollRunnable?.let {
            bannerAutoScrollHandler?.removeCallbacks(it)
        }
        bannerAutoScrollHandler = null
        bannerAutoScrollRunnable = null
    }

    private fun setupDestaquesRecyclerView(view: View) {
        val destaquesRecyclerView: RecyclerView = view.findViewById(R.id.destaquesRecyclerView)

        // Configurar layout manager
        val layoutManager = LinearLayoutManager(
            context,
            LinearLayoutManager.HORIZONTAL,
            false
        )
        destaquesRecyclerView.layoutManager = layoutManager

        // Adicionar SnapHelper para centralizar os cards
        val snapHelper = PagerSnapHelper()
        snapHelper.attachToRecyclerView(destaquesRecyclerView)

        // Lista de destaques com URLs (VOCÊ PODE TROCAR AS URLs AQUI!)
        val destaques = listOf(
            Destaque(
                title = "IFSP Campus Catanduva protagoniza projeto inovador de podcasts sobre temas do Enem e acerta o tema central de 2025",
                imageRes = R.drawable.destaque1,
                url = "https://ctd.ifsp.edu.br/index.php/component/content/article/35-destaques/891-ifsp-campus-catanduva-protagoniza-projeto-inovador-de-podcasts-sobre-temas-do-enem-e-acerta-o-tema-central-de-2025"
            ),
            Destaque(
                title = "IFSP abre concurso público com 21 vagas",
                imageRes = R.drawable.destaque2,
                url = "https://ctd.ifsp.edu.br/index.php/component/content/article/35-destaques/881-ifsp-abre-concurso-publico-com-21-vagas-para-cargos-tecnico-administrativos"
            ),
            Destaque(
                title = "Processo seletivo de professor substituto",
                imageRes = R.drawable.destaque3,
                url = "https://ctd.ifsp.edu.br/index.php/component/content/article/35-destaques/887-edital-n-99-2025-ifsp-inscreve-para-processo-seletivo-de-professor-substituto"
            )
        )

        destaquesRecyclerView.adapter = DestaqueAdapter(destaques)

        // Configurar auto-scroll do carrossel de destaques
        startDestaquesAutoScroll(destaquesRecyclerView, destaques.size)
    }

    private fun startDestaquesAutoScroll(recyclerView: RecyclerView, itemCount: Int) {
        destaquesAutoScrollHandler = Handler(Looper.getMainLooper())
        destaquesAutoScrollRunnable = object : Runnable {
            override fun run() {
                if (itemCount > 0) {
                    currentDestaquePosition = (currentDestaquePosition + 1) % itemCount
                    recyclerView.smoothScrollToPosition(currentDestaquePosition)
                    destaquesAutoScrollHandler?.postDelayed(this, 4000) // Troca a cada 4 segundos
                }
            }
        }
        destaquesAutoScrollHandler?.postDelayed(destaquesAutoScrollRunnable!!, 4000)
    }

    private fun stopDestaquesAutoScroll() {
        destaquesAutoScrollRunnable?.let {
            destaquesAutoScrollHandler?.removeCallbacks(it)
        }
        destaquesAutoScrollHandler = null
        destaquesAutoScrollRunnable = null
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