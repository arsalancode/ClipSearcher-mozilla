package com.mozilla.clipsearcher.ui

import android.content.ClipboardManager
import android.content.Context
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.mozilla.clipsearcher.vm.SearchViewModel
import com.mozilla.clipsearcher.databinding.FragmentSearchBinding
import com.mozilla.clipsearcher.utils.getData
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_search.*
import kotlinx.coroutines.*

@FlowPreview
@AndroidEntryPoint
@OptIn(ExperimentalCoroutinesApi::class)
class SearchFragment : Fragment() {

    private val searchViewModel: SearchViewModel by viewModels()

    lateinit var clipboard : ClipboardManager

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = FragmentSearchBinding.inflate(inflater, container, false).apply {
        viewModel = searchViewModel
        lifecycleOwner = viewLifecycleOwner
    }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        clipboard = requireActivity().getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager

        setupTextChangeListener()
        observeShowResult()
    }

    override fun onResume() {
        super.onResume()

        viewLifecycleOwner.lifecycleScope.launch {
            delay(500)
            copyClipData()
        }
    }

    private fun copyClipData() {
        val text = clipboard.getData()
        if(text.isNotEmpty()){
            eSearch.setText(text)
        }
    }

    private fun observeShowResult() {
        searchViewModel.showResults.observe(viewLifecycleOwner) {
            if (it) {
                searchViewModel.resultsDisplayed()
                val action =
                    SearchFragmentDirections.actionSearchFragmentToWebViewFragment(searchViewModel.getSearchText())
                findNavController().navigate(action)
            }
        }
    }

    private fun setupTextChangeListener() {
        eSearch.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

            override fun afterTextChanged(s: Editable?) {
                searchViewModel.afterTextChanged(s.toString())
            }
        })
    }

}