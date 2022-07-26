package com.example.taskfromellco.presentation.lenta

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.taskfromellco.utils.ViewModelFactory
import com.example.taskfromellco.App
import com.example.taskfromellco.databinding.FragmentLentaBinding
import com.example.taskfromellco.presentation.list.ListFragment
import com.example.taskfromellco.utils.SpaceItemDecoration
import javax.inject.Inject

class LentaFragment : Fragment() {

    lateinit var binding: FragmentLentaBinding

    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    private val viewModel by lazy {
        ViewModelProvider(this,viewModelFactory)[LentaViewModel::class.java]
    }

    private val adapterMain = AdapterLenta{
        viewModel.saveArticleModel(it)
    }

    private val component by lazy {
        (requireActivity().application as App).component
            .lentaComp()
            .create()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentLentaBinding.inflate(inflater, container, false)
        component.inject(this)


        setupRV()
        getData()
        setupSearchView()
        visivilityProgress()
        return binding.root
    }

    private fun visivilityProgress() {
        binding.progressLenta.visibility = View.VISIBLE
    }

    private fun getData() {
        with(binding.rvLenta) {
            adapter = adapterMain
            addItemDecoration(
                SpaceItemDecoration(
                    ListFragment.MARGIN_SPACING_VALUE_34,
                    ListFragment.MARGIN_LEFT_VALUE_34,
                    ListFragment.MARGIN_RIGHT_VALUE_34
                )
            )
            setHasFixedSize(true)
            viewModel.getAllNews{
                adapterMain.submitList(it)
                binding.progressLenta.visibility = View.GONE
            }
        }

    }

    private fun setupSearchView() {
        binding.searchLenta.setOnCloseListener(object : SearchView.OnCloseListener{
            override fun onClose(): Boolean {
                viewModel.getAllNews {
                    adapterMain.submitList(it)
                    binding.progressLenta.visibility = View.GONE
                }
                return false
            }
        })
        binding.searchLenta.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                viewModel.searchQuery(query ?: "") {
                    adapterMain.submitList(it)
                }
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return false
            }
        })
    }

    private fun setupRV() {
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}