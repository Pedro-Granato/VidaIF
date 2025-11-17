package br.edu.ifsp.vidaif.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.edu.ifsp.vidaif.R
import br.edu.ifsp.vidaif.adapter.EventAdapter
import br.edu.ifsp.vidaif.model.Event

class EventsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_events, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupEventsRecyclerView(view)
    }

    private fun setupEventsRecyclerView(view: View) {
        val eventsRecyclerView: RecyclerView = view.findViewById(R.id.upcomingEventsRecyclerView)
        eventsRecyclerView.layoutManager = LinearLayoutManager(context)

        val eventsList = listOf(
            Event(
                title = "Maratona de Programação IFSP",
                date = "28 de Junho • 08:00 - 18:00",
                content = "Competição de programação aberta para estudantes do ensino médio e superior. Inscrições gratuitas!",
                badge = "Inscreva-se"
            ),
            Event(
                title = "Feira de Profissões",
                date = "05 de Julho • 14:00 - 17:00",
                content = "Conheça todos os cursos do IFSP Catanduva. Palestras, demonstrações e muito mais!",
                badge = "05/07"
            ),
            Event(
                title = "Workshop: Inteligência Artificial",
                date = "12 de Julho • 19:00 - 21:00",
                content = "Introdução prática ao mundo da IA. Aberto à comunidade externa.",
                badge = "12/07"
            )
        )

        eventsRecyclerView.adapter = EventAdapter(eventsList)
    }
}