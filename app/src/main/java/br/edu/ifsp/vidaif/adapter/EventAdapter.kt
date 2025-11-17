package br.edu.ifsp.vidaif.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.edu.ifsp.vidaif.R
import br.edu.ifsp.vidaif.model.Event

class EventAdapter(private val eventList: List<Event>) :
    RecyclerView.Adapter<EventAdapter.EventViewHolder>() {

    private var lastPosition = -1

    class EventViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title: TextView = itemView.findViewById(R.id.eventTitle)
        val date: TextView = itemView.findViewById(R.id.eventDate)
        val content: TextView = itemView.findViewById(R.id.eventContent)
        val badge: TextView = itemView.findViewById(R.id.eventBadge)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_event, parent, false)
        return EventViewHolder(view)
    }

    override fun onBindViewHolder(holder: EventViewHolder, position: Int) {
        val event = eventList[position]
        holder.title.text = event.title

        if (event.date != null) {
            holder.date.text = event.date
            holder.date.visibility = View.VISIBLE
        } else {
            holder.date.visibility = View.GONE
        }

        holder.content.text = event.content
        holder.badge.text = event.badge

        // Animate item
        setAnimation(holder.itemView, position)
    }

    private fun setAnimation(viewToAnimate: View, position: Int) {
        if (position > lastPosition) {
            val animation = AnimationUtils.loadAnimation(viewToAnimate.context, R.anim.item_animation)
            viewToAnimate.startAnimation(animation)
            lastPosition = position
        }
    }

    override fun getItemCount() = eventList.size
}