package com.mozilla.clipsearcher

import androidx.lifecycle.*
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.*
import javax.inject.Inject

@ExperimentalCoroutinesApi
@FlowPreview
@HiltViewModel
class SearchViewModel @Inject constructor()  : ViewModel() {

    private val TAG = "HomeViewModel"
    var enableButton = MutableLiveData(false)
    var searchTerm = ""

    var searchQuery = MutableLiveData("")

    init {
    }

    fun afterTextChanged(text: String){
        enableButton.postValue(text.trim().isNotEmpty())
        searchTerm = text.trim()
    }

    fun onSearchButtonClick(){
        // Open WebView
        searchQuery.postValue(searchTerm)
    }

}