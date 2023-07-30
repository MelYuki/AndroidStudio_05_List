package be.melyuki.demo05_list.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import be.melyuki.demo05_list.R
import be.melyuki.demo05_list.models.Teacher

class TeacherAdapter(val Context : Context, val Teachers : List<Teacher> ) : RecyclerView.Adapter<TeacherAdapter.TeacherViewHolder>()  {

    class TeacherViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val TvFirstName : TextView
        val TvLastName : TextView

        init {
            TvFirstName = itemView.findViewById(R.id.item_teacher_firstname)
            TvLastName = itemView.findViewById(R.id.item_teacher_lastname)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeacherViewHolder {
        val v : View = LayoutInflater.from(Context).inflate(R.layout.item_teacher, parent, false)
        return TeacherViewHolder(v)
    }

    override fun getItemCount(): Int {
        return Teachers.size
    }

    override fun onBindViewHolder(holder: TeacherViewHolder, position: Int) {
        val target : Teacher = Teachers[position]

        holder.TvFirstName.setText(target.FirstName)
        holder.TvLastName.setText(target.LastName)
    }
}