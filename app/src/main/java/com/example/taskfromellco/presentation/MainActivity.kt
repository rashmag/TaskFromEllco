package com.example.taskfromellco.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.taskfromellco.R
import com.example.taskfromellco.databinding.ActivityMainBinding
import com.example.taskfromellco.domain.model.DBModel

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    private val viewModel by lazy {
        ViewModelProvider(this)[MainActivityViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setClickBtns()
    }

    private fun setClickBtns() {
        with(binding) {
            btnSave.setOnClickListener {
                val edText = editText.text.toString()
                if (edText.isNotEmpty()) {
                    viewModel.saveValue(DBModel(0, edText))
                } else {
                    editText.error = "Заполните поле"
                }
            }
            btnLoad.setOnClickListener {
                viewModel.valueList.observe(this@MainActivity) {
                    result.text = it.value
                }
            }
        }
    }
}