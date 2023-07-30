package be.melyuki.demo05_list

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import be.melyuki.demo05_list.databinding.ActivityMenuBinding

class MenuActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMenuBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnMenuList.setOnClickListener{ demoList() }
        binding.btnMenuRecycler.setOnClickListener{ demoRecycler() }
    }

    private fun demoList() {
        val intent = Intent(this, StudentActivity::class.java)
        startActivity(intent)
    }

    private fun demoRecycler() {
        val intent = Intent(this, TeacherActivity::class.java)
        startActivity(intent)
    }
}