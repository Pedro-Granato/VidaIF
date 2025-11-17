package br.edu.ifsp.vidaif.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.edu.ifsp.vidaif.R
import br.edu.ifsp.vidaif.model.Course
import br.edu.ifsp.vidaif.model.CourseCategory

class CourseCategoryAdapter(private val categories: List<CourseCategory>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        private const val VIEW_TYPE_CATEGORY_TITLE = 0
        private const val VIEW_TYPE_COURSE = 1
    }

    private val items = mutableListOf<Any>()

    init {
        // Flatten the structure: category title followed by its courses
        categories.forEach { category ->
            items.add(category.categoryName)
            items.addAll(category.courses)
        }
    }

    class CategoryTitleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val titleText: TextView = itemView.findViewById(R.id.categoryTitleText)
    }

    class CourseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title: TextView = itemView.findViewById(R.id.courseTitle)
        val info: TextView = itemView.findViewById(R.id.courseInfo)
        val description: TextView = itemView.findViewById(R.id.courseDescription)
        val featuresList: LinearLayout = itemView.findViewById(R.id.featuresList)
    }

    override fun getItemViewType(position: Int): Int {
        return if (items[position] is String) {
            VIEW_TYPE_CATEGORY_TITLE
        } else {
            VIEW_TYPE_COURSE
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (viewType == VIEW_TYPE_CATEGORY_TITLE) {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_category_title, parent, false)
            CategoryTitleViewHolder(view)
        } else {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_course, parent, false)
            CourseViewHolder(view)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is CategoryTitleViewHolder -> {
                val categoryName = items[position] as String
                holder.titleText.text = categoryName
            }
            is CourseViewHolder -> {
                val course = items[position] as Course
                holder.title.text = course.title
                holder.info.text = course.info
                holder.description.text = course.description

                // Add features if available
                if (course.features != null && course.features.isNotEmpty()) {
                    holder.featuresList.visibility = View.VISIBLE
                    holder.featuresList.removeAllViews()

                    course.features.forEach { feature ->
                        val featureView = LayoutInflater.from(holder.itemView.context)
                            .inflate(android.R.layout.simple_list_item_1, holder.featuresList, false)
                        val textView = featureView.findViewById<TextView>(android.R.id.text1)
                        textView.text = "• $feature"
                        textView.textSize = 12f
                        textView.setTextColor(holder.itemView.context.getColor(R.color.text_secondary))
                        holder.featuresList.addView(featureView)
                    }
                } else {
                    holder.featuresList.visibility = View.GONE
                }
            }
        }
    }

    override fun getItemCount() = items.size
}