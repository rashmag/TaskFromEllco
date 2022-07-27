package com.example.taskfromellco.presentation.favorite

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.taskfromellco.App
import com.example.taskfromellco.R
import com.example.taskfromellco.databinding.FragmentFavoriteBinding
import com.example.taskfromellco.presentation.one_element.OneElementFragment
import com.example.taskfromellco.utils.MainMapper
import com.example.taskfromellco.utils.SpaceItemDecoration
import com.example.taskfromellco.utils.ViewModelFactory
import javax.inject.Inject

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
        AdapterFavorite ({
            viewModel.deleteArticle(it){
                getAllList()
            }
        },{
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(
                    R.id.container_fragment,
                    OneElementFragment.newInstance(MainMapper().mapArticleDomainModelToArticalModel(it))
                ).addToBackStack(null).commit()
        })
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFavoriteBinding.inflate(inflater, container, false)
        component.inject(this)

        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupSearchView()
        setupRV()
    }

    private fun setupSearchView() {
        viewModel.setupSearchView(binding.searchViewFavorite,adapterFavorite)
    }

    private fun setupRV() {
        with(binding.rvFavorite) {
            adapter = adapterFavorite
            setHasFixedSize(true)
            addItemDecoration(SpaceItemDecoration(
                MARGIN_SPACING_VALUE_34,
                MARGIN_LEFT_VALUE_34,
                MARGIN_RIGHT_VALUE_34
            ))
        }

        getAllList()
    }
    private fun getAllList() {
        viewModel.loadAllList{
            adapterFavorite.submitList(it)
        }
    }
    companion object{
        private const val MARGIN_SPACING_VALUE_34 = 34
        private const val MARGIN_LEFT_VALUE_34 = 10
        private const val MARGIN_RIGHT_VALUE_34 = 10
    }
}