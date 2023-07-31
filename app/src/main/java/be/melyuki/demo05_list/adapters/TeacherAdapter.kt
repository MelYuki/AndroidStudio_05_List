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

        // Encapsule la view d'un item de la liste
        // - Permet de récup les différents éléments de la view

        val TvFirstName : TextView
        val TvLastName : TextView
        init {
            // Récup des éléments via la méthode "findViewById" depuis la view reçue
            TvFirstName = itemView.findViewById(R.id.item_teacher_firstname)
            TvLastName = itemView.findViewById(R.id.item_teacher_lastname)
        }
    }

    // La fait d'hériter de "RecyclerView.Adapter" oblige l'override de ces 3 méthodes
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeacherViewHolder {
        // La méthode appelée crée une view encapsulée dans un ViewHolder
        val v : View = LayoutInflater.from(Context).inflate(R.layout.item_teacher, parent, false)
        return TeacherViewHolder(v)
    }

    override fun onBindViewHolder(holder: TeacherViewHolder, position: Int) {
        // Méthode appelée pour remplir le contenu de la view en fonction de la position dans la liste
        val target : Teacher = Teachers[position]

        holder.TvFirstName.setText(target.FirstName)
        holder.TvLastName.setText(target.LastName)
    }

    override fun getItemCount(): Int {
        // Méthode appelée pour obtenir le nombre d'élément dans la liste (nécessaire pour le visuel)
        return Teachers.size
    }

}