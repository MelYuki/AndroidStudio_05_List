package be.melyuki.demo05_list

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SimpleAdapter
import be.melyuki.demo05_list.databinding.ActivityStudentBinding
import be.melyuki.demo05_list.models.Student

class StudentActivity : AppCompatActivity() {

    private lateinit var binding: ActivityStudentBinding

    private val students : List<Student> = listOf(
        Student("Riri", "Duck"),
        Student("Zaza", "Vanderquack"),
        Student("Gontran", "Bonheur"),
        Student("Daisy", "Duck"),
        Student("Donald", "Duck")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Binding du layout
        binding = ActivityStudentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Création d'un adapter pour gérer les données pour la ListView
        // v1 - ArrayAdapter
        /*
        val adapter : ArrayAdapter<Student> = ArrayAdapter(
         this,
            android.R.layout.simple_list_item_1, // Template utilisé
            android.R.id.text1,
            students
        )
        */

        // v2 - SimpleAdapter
        val data : MutableList<Map<String, String>> = mutableListOf()

        for (student in students) {

            // Décomposition des données sous la forme d'une "map"
            val line : MutableMap<String, String> = mutableMapOf()
            line["firstname"] = student.FirstName
            line.put("lastname", student.LastName)

            // Ajout de la "map" dans la "list"
            data.add(line)
        }

        val from : Array<String> = arrayOf("firstname", "lastname")
        val to : IntArray = arrayOf(android.R.id.text1, android.R.id.text2).toIntArray()

        val adapter : SimpleAdapter = SimpleAdapter(
            this,
            data,
            android.R.layout.simple_list_item_2,
            from,
            to
        )

        // Lien entre l'adapter et la ListView
        binding.lvStudent.adapter = adapter
    }
}