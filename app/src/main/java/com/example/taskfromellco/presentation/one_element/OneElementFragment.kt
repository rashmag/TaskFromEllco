package com.example.taskfromellco.presentation.one_element

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.taskfromellco.App
import com.example.taskfromellco.data.remote_db.ArticleModel
import com.example.taskfromellco.databinding.FragmentOneElementListBinding


class OneElementFragment : Fragment() {

    lateinit var binding: FragmentOneElementListBinding

    private val component by lazy {
        (requireActivity().application as App).component
            .oneElementListComp()
            .create()
    }

    private var articleModel: ArticleModel? = null

    private val viewModel by lazy {
        ViewModelProvider(this)[OneFramentViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentOneElementListBinding.inflate(inflater, container, false)
        component.inject(this)
        parceArgs()
        return binding.root
    }

    private fun parceArgs() {
        requireArguments().getParcelable<ArticleModel>(KEY).apply {
            articleModel = this
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupViews()
    }

    private fun setupViews() {
        articleModel?.let {
            viewModel.setupViews(articleModel!!,binding,requireContext())
        }
    }

    companion object {
        private val KEY = "articleModel"
        fun newInstance(args: ArticleModel): OneElementFragment {
            return OneElementFragment().apply {
                arguments = Bundle().apply {
                    putParcelable(KEY, args)
                }
            }
        }
    }
}