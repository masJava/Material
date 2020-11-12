package com.mas.material.ui.style

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class StyleViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is blue theme Fragment"
    }
    val text: LiveData<String> = _text
}