package br.edu.ifsp.vidaif.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.edu.ifsp.vidaif.R
import br.edu.ifsp.vidaif.model.Destaque

class DestaqueAdapter(private val destaques: List<Destaque>) :
    RecyclerView.Adapter<DestaqueAdapter.DestaqueViewHolder>() {

    class DestaqueViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val image: ImageView = itemView.findViewById(R.id.destaqueImage)
        val title: TextView = itemView.findViewById(R.id.destaqueTitle)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DestaqueViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_destaque, parent, false)
        return DestaqueViewHolder(view)
    }

    override fun onBindViewHolder(holder: DestaqueViewHolder, position: Int) {
        val destaque = destaques[position]
        holder.image.setImageResource(destaque.imageRes)
        holder.title.text = destaque.title
    }

    override fun getItemCount() = destaques.size
}