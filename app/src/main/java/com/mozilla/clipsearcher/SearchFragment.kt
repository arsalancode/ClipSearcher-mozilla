package com.mozilla.clipsearcher

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
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
        lifecycleOwner = viewLifecycleOwner
    }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupTextChangeListener()
//        bSearch.setOnClickListener {
//            Toast.makeText(requireContext(), "Find Item ", Toast.LENGTH_SHORT).show()
//        }

    }

    private fun setupTextChangeListener() {
        eSearch.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

            override fun afterTextChanged(s: Editable?) {
                homeViewModel.afterTextChanged(s.toString())
            }
        })
    }
}