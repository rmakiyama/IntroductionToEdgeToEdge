package com.rmakiyama.introductiontoedgetoedge

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel :ViewModel() {

    private val _texts = MutableLiveData<List<String>>()
    val texts: LiveData<List<String>> get() = _texts

    init {
        _texts.value = listOf(
            "QNLpqgu7bK",
            "wCGYBrCGPI",
            "g1muB65EFz",
            "gDd4qLMFb8",
            "nb3llXXUvo",
            "RyGZrGV9A9",
            "CQw6t0QpOj",
            "FEDWGzPmfx",
            "PBBo7Cve3b",
            "PwZQrVBY1s",
            "suPnbYCIyO",
            "hJwQkW0Rvl",
            "vFq9kDP4Br",
            "N9Qd7c8QP5",
            "PrGbIyN7zg",
            "ZIL1MVEq0x",
            "vCEWpqoL3Z",
            "a9D1QfVnJ9",
            "70SEn2aLWc",
            "WP0Z8NjO6A"
        )
    }
}