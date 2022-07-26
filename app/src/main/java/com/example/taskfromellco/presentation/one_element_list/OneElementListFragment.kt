package com.example.taskfromellco.presentation.one_element_list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.taskfromellco.App
import com.example.taskfromellco.databinding.FragmentListBinding
import com.example.taskfromellco.databinding.FragmentOneElementListBinding
import com.example.taskfromellco.presentation.list.ListModel
import com.example.taskfromellco.utils.SpaceItemDecoration

class OneElementListFragment : Fragment() {

    lateinit var binding: FragmentOneElementListBinding

    private val component by lazy {
        (requireActivity().application as App).component
            .oneElementListComp()
            .create()
    }

    private var listModel:ListModel? = null

//    private val viewModel by lazy {
//        ViewModelProvider(this).get(ListViewModel::class.java)
//    }

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
        requireArguments().getParcelable<ListModel>(KEY).apply {
            listModel = this
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupViews()
    }

    private fun setupViews() {
        listModel?.img?.let {
            binding.imgOne.setImageResource(it)
        }
        listModel?.value?.let {
            binding.nameOne.text = it
        }
    }

    companion object {
        private val KEY = "listModel"
        fun newInstance(args:ListModel):OneElementListFragment{
            return OneElementListFragment().apply {
                arguments = Bundle().apply {
                    putParcelable(KEY,args)
                }
            }
        }
    }
}