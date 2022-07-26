package com.mozilla.clipsearcher

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import com.mozilla.clipsearcher.databinding.FragmentSearchBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.android.synthetic.main.fragment_search.*

@FlowPreview
@AndroidEntryPoint
class SearchFragment : Fragment() {

    @ExperimentalCoroutinesApi
    private val homeViewModel: HomeViewModel by viewModels()

    @OptIn(ExperimentalCoroutinesApi::class)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = FragmentSearchBinding.inflate(inflater, container, false).apply {
        viewModel = homeViewModel
    }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        bSearch.setOnClickListener {
            Toast.makeText(requireContext(), "Find Item ", Toast.LENGTH_SHORT).show()
        }
    }

}