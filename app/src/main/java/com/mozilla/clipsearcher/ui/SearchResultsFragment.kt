package com.mozilla.clipsearcher.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.mozilla.clipsearcher.databinding.FragmentWebviewBinding
import com.mozilla.clipsearcher.utils.getUrl
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.FlowPreview
import kotlinx.android.synthetic.main.fragment_webview.*

@FlowPreview
@AndroidEntryPoint
class SearchResultsFragment : Fragment() {

    private val args: SearchResultsFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = FragmentWebviewBinding.inflate(inflater, container, false).root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        args.query?.let {
            webview.settings.javaScriptEnabled = true
            webview.loadUrl(it.getUrl())
        }

    }
}