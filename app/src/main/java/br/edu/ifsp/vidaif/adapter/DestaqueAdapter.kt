package br.edu.ifsp.vidaif.adapter

import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
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

        // Adiciona animação suave ao aparecer
        val animation = AnimationUtils.loadAnimation(holder.itemView.context, R.anim.slide_in_right)
        holder.itemView.startAnimation(animation)

        // Adiciona click listener para abrir URL
        holder.itemView.setOnClickListener {
            if (destaque.url.isNotEmpty()) {
                try {
                    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(destaque.url))
                    holder.itemView.context.startActivity(intent)
                } catch (e: Exception) {
                    Toast.makeText(
                        holder.itemView.context,
                        "Não foi possível abrir o link",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }

        // Adiciona efeito de elevação ao clicar
        if (destaque.url.isNotEmpty()) {
            holder.itemView.isClickable = true
            holder.itemView.isFocusable = true
        }
    }

    override fun getItemCount() = destaques.size
}