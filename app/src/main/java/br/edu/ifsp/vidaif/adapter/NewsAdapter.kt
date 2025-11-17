package br.edu.ifsp.vidaif.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.edu.ifsp.vidaif.R
import br.edu.ifsp.vidaif.model.News

class NewsAdapter(private val newsList: List<News>) :
    RecyclerView.Adapter<NewsAdapter.NewsViewHolder>() {

    private var lastPosition = -1

    class NewsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title: TextView = itemView.findViewById(R.id.newsTitle)
        val date: TextView = itemView.findViewById(R.id.newsDate)
        val content: TextView = itemView.findViewById(R.id.newsContent)
        val badge: TextView = itemView.findViewById(R.id.newsBadge)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_news, parent, false)
        return NewsViewHolder(view)
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val news = newsList[position]
        holder.title.text = news.title
        holder.date.text = "Publicado em ${news.date}"
        holder.content.text = news.content
        holder.badge.visibility = if (news.isNew) View.VISIBLE else View.GONE

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

    override fun getItemCount() = newsList.size
}