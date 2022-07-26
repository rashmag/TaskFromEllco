package com.example.taskfromellco.presentation.favorite

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.taskfromellco.utils.ViewModelFactory
import com.example.taskfromellco.App
import com.example.taskfromellco.databinding.FragmentFavoriteBinding
import com.example.taskfromellco.domain.model.ArticalDomainModel
import javax.inject.Inject
import kotlin.concurrent.thread

class FavoriteFragment : Fragment() {

    lateinit var binding: FragmentFavoriteBinding

    private val component by lazy {
        (requireActivity().application as App).component
            .favoriteComp()
            .create()
    }

    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    private val viewModel by lazy {
        ViewModelProvider(this, viewModelFactory)[FavoriteViewModel::class.java]
    }
    val adapterFavorite by lazy {
        AdapterFavorite {
            viewModel.deleteArticle(it){
                getAllList()
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFavoriteBinding.inflate(inflater, container, false)
        component.inject(this)

        setupSearchView()
        return binding.root
    }

    private fun setupSearchView() {
        viewModel.setupSearchView(binding.searchViewFavorite,adapterFavorite)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRV()
    }

    private fun setupRV() {
        with(binding.rvFavorite) {
            adapter = adapterFavorite
            setHasFixedSize(true)
        }

        getAllList()
    }
    private fun getAllList() {
        viewModel.loadAllList{
            adapterFavorite.submitList(it)
        }
    }
}