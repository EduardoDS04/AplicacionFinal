package com.example.aplicacionfragmentos

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.aplicacionfragmentos.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var controller: Controller
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()
    }
    fun init() {
        initRecyclerView()
        controller = Controller(this)
        controller.setAdapter()
        binding.btnAdd.setOnClickListener {
            controller.showEditDialog(null, null)
        }
    }
    private fun initRecyclerView() {
        binding.myRecyclerView.layoutManager = LinearLayoutManager(this)
    }
}
