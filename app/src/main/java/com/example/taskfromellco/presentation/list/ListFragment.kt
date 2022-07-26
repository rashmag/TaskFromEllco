package com.example.taskfromellco.presentation.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.taskfromellco.App
import com.example.taskfromellco.R
import com.example.taskfromellco.databinding.FragmentListBinding
import com.example.taskfromellco.presentation.one_element_list.OneElementListFragment
import com.example.taskfromellco.utils.SpaceItemDecoration

class ListFragment : Fragment() {

    lateinit var binding: FragmentListBinding

    private val component by lazy {
        (requireActivity().application as App).component
            .listComp()
            .create()
    }
    private val adapterMain by lazy {
        AdapterList {
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(
                    R.id.container_fragment,
                    OneElementListFragment.newInstance(it)
                )
                .addToBackStack(null)
                .commit()
        }
    }

    private val viewModel by lazy {
        ViewModelProvider(this).get(ListViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentListBinding.inflate(inflater, container, false)
        component.inject(this)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRecyclerView()
    }


    private fun setupRecyclerView() {
        with(binding.recyclerViewList) {
            adapter = adapterMain
            addItemDecoration(
                SpaceItemDecoration(
                    MARGIN_SPACING_VALUE_34,
                    MARGIN_LEFT_VALUE_34,
                    MARGIN_RIGHT_VALUE_34
                )
            )
            setHasFixedSize(true)
        }
        adapterMain.submitList(createList())
    }

    private fun createList(): ArrayList<ListModel> {
        val arrayList: ArrayList<ListModel> = arrayListOf()
        repeat(20) {
            arrayList.add(ListModel(R.drawable.ic_launcher_background, "Название $it"))
        }
        return arrayList
    }

    companion object {
        const val MARGIN_SPACING_VALUE_34 = 34
        const val MARGIN_LEFT_VALUE_34 = 10
        const val MARGIN_RIGHT_VALUE_34 = 10
    }
}