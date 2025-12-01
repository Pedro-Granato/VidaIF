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
import br.edu.ifsp.vidaif.model.Banner

class BannerAdapter(private val banners: List<Banner>) :
    RecyclerView.Adapter<BannerAdapter.BannerViewHolder>() {

    class BannerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val bannerImage: ImageView = itemView.findViewById(R.id.bannerImage)
        val bannerCategory: TextView = itemView.findViewById(R.id.bannerCategory)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BannerViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_banner, parent, false)
        return BannerViewHolder(view)
    }

    override fun onBindViewHolder(holder: BannerViewHolder, position: Int) {
        val banner = banners[position]
        holder.bannerImage.setImageResource(banner.imageRes)

        // Mostrar ou esconder categoria
        if (banner.category.isNotEmpty()) {
            holder.bannerCategory.text = banner.category
            holder.bannerCategory.visibility = View.VISIBLE
        } else {
            holder.bannerCategory.visibility = View.GONE
        }

        // Adiciona animação suave ao aparecer
        val animation = AnimationUtils.loadAnimation(holder.itemView.context, R.anim.fade_in)
        holder.itemView.startAnimation(animation)

        // Adiciona click listener para abrir URL
        holder.itemView.setOnClickListener {
            if (banner.url.isNotEmpty()) {
                try {
                    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(banner.url))
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

        // Adiciona feedback visual ao clicar
        if (banner.url.isNotEmpty()) {
            holder.itemView.foreground = holder.itemView.context.getDrawable(
                android.R.drawable.list_selector_background
            )
        }
    }

    override fun getItemCount() = banners.size
}