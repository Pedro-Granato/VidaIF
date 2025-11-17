package br.edu.ifsp.vidaif.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.edu.ifsp.vidaif.R
import br.edu.ifsp.vidaif.model.Course

class CourseAdapter(private val courseList: List<Course>) :
    RecyclerView.Adapter<CourseAdapter.CourseViewHolder>() {

    class CourseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title: TextView = itemView.findViewById(R.id.courseTitle)
        val info: TextView = itemView.findViewById(R.id.courseInfo)
        val description: TextView = itemView.findViewById(R.id.courseDescription)
        val featuresList: LinearLayout = itemView.findViewById(R.id.featuresList)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CourseViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_course, parent, false)
        return CourseViewHolder(view)
    }

    override fun onBindViewHolder(holder: CourseViewHolder, position: Int) {
        val course = courseList[position]
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

    override fun getItemCount() = courseList.size
}