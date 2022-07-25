package com.example.taskfromellco.presentation.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.taskfromellco.R
import com.example.taskfromellco.databinding.FragmentListBinding

class ListFragment : Fragment() {

    lateinit var binding: FragmentListBinding

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val viewModel by lazy {
        ViewModelProvider(this).get(ListViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentListBinding.inflate(inflater, container, false)
        setupRecyclerView()
        return binding.root
    }


    private fun setupRecyclerView() {
        val adapterMain = AdapterListRecycler()
        binding.recyclerViewList.adapter = adapterMain
        binding.recyclerViewList.addItemDecoration(
            SpaceItemDecoration(
                MARGIN_SPACING_VALUE_34,
                MARGIN_LEFT_VALUE_34,
                MARGIN_RIGHT_VALUE_34
            )
        )
        adapterMain.submitList(createList())
    }

    private fun createList(): ArrayList<ListModel> {
        val arrayList: ArrayList<ListModel> = arrayListOf()
        repeat(20) {
            arrayList.add(ListModel("Название"))
        }
        return arrayList
    }

    companion object {
        private const val MARGIN_SPACING_VALUE_34 = 34
        private const val MARGIN_LEFT_VALUE_34 = 10
        private const val MARGIN_RIGHT_VALUE_34 = 10
    }
}