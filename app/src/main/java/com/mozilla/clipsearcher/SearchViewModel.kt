package com.mozilla.clipsearcher

import androidx.lifecycle.*
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.*
import javax.inject.Inject

@ExperimentalCoroutinesApi
@FlowPreview
@HiltViewModel
class SearchViewModel @Inject constructor()  : ViewModel() {

    private val TAG = "SearchViewModel"
    var enableButton = MutableLiveData(false)
    private var searchTerm = ""

    var showResults = MutableLiveData(false)


    fun getSearchText() : String = searchTerm

    fun resultsDisplayed() {
        showResults.value = false
    }

    fun afterTextChanged(text: String){
        enableButton.postValue(text.trim().isNotEmpty())
        searchTerm = text.trim()
    }

    fun onSearchButtonClick(){
        // Open WebView
        showResults.postValue(true)
    }

}