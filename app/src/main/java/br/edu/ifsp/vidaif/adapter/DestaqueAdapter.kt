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
            Toast.makeText(
                holder.itemView.context,
                "Clique detectado!",
                Toast.LENGTH_SHORT
            ).show()

            if (destaque.url.isNotEmpty()) {
                try {
                    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(destaque.url))
                    holder.itemView.context.startActivity(intent)
                } catch (e: Exception) {
                    Toast.makeText(
                        holder.itemView.context,
                        "Erro: ${e.message}",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            } else {
                Toast.makeText(
                    holder.itemView.context,
                    "Este destaque não possui link",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

        // Adiciona efeito de elevação ao clicar
        holder.itemView.isClickable = true
        holder.itemView.isFocusable = true

        // Adiciona feedback visual ao clicar
        if (destaque.url.isNotEmpty()) {
            holder.itemView.foreground = holder.itemView.context.getDrawable(
                android.R.drawable.list_selector_background
            )
        }
    }

    override fun getItemCount() = destaques.size
}