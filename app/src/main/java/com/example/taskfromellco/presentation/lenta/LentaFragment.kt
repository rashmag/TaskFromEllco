package com.example.taskfromellco.presentation.lenta

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.taskfromellco.App
import com.example.taskfromellco.R
import com.example.taskfromellco.databinding.FragmentLentaBinding
import com.example.taskfromellco.presentation.favorite.FavoriteFragmentDirections
import com.example.taskfromellco.presentation.main_activity.MainActivity
import com.example.taskfromellco.presentation.one_element.OneElementFragment
import com.example.taskfromellco.utils.MainMapper
import com.example.taskfromellco.utils.SpaceItemDecoration
import com.example.taskfromellco.utils.ViewModelFactory
import com.example.taskfromellco.utils.gone
import javax.inject.Inject

class LentaFragment : Fragment() {

    lateinit var binding: FragmentLentaBinding

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private val viewModel by lazy {
        ViewModelProvider(this, viewModelFactory)[LentaViewModel::class.java]
    }

    private val adapterMain = AdapterLenta({
        viewModel.saveArticleModel(it)
    },{
        it
        val action = LentaFragmentDirections.
        actionNavigationLentaToOneElementFragment(it)
        findNavController().navigate(action)
    })

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


        getData()
        setupSearchView()
        return binding.root
    }

    private fun getData() {
        with(binding.rvLenta) {
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
        viewModel.getAllNewsRetrofit {
            adapterMain.submitList(it)
            binding.progressLenta.gone()
        }
    }

    private fun setupSearchView() {
        binding.searchLenta.setOnCloseListener(object : SearchView.OnCloseListener {
            override fun onClose(): Boolean {
                viewModel.getAllNewsRetrofit {
                    adapterMain.submitList(it)
                    binding.progressLenta.gone()
                }
                return false
            }
        })
        binding.searchLenta.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
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

    companion object {
        private const val MARGIN_SPACING_VALUE_34 = 34
        private const val MARGIN_LEFT_VALUE_34 = 10
        private const val MARGIN_RIGHT_VALUE_34 = 10
    }
}