package com.example.taskfromellco.presentation.main_activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.taskfromellco.R
import com.example.taskfromellco.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    private val viewModel by lazy {
        ViewModelProvider(this)[MainActivityViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.containerFragment) as NavHostFragment
        val navController: NavController = navHostFragment.navController
//        val appBarConfiguration = AppBarConfiguration(
//            setOf(
//                R.id.navigation_favorite, R.id.navigation_lenta, R.id.navigation_list
//            )
//        )
//        setupActionBarWithNavController(navController, appBarConfiguration)


        binding.navView.setupWithNavController(navController)
     }

    private fun setClickBtns() {
//        with(binding) {
//
//            btnSave.setOnClickListener {
//                val edText = editText.text.toString()
//                if (edText.isNotEmpty()) {
//                    viewModel.saveValue(DBModel(0, edText))
//                } else {
//                    editText.error = "Заполните поле"
//                }
//            }
//            btnLoad.setOnClickListener {
//                viewModel.valueList.observe(this@MainActivity) {
//                    result.text = it.value
//                }
//            }
//        }
    }
}