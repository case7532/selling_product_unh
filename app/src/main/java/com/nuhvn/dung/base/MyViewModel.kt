package com.nuhvn.dung.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.gson.GsonBuilder

abstract class MyViewModel : ViewModel() {
	val sGson = GsonBuilder().create()
	val error = MutableLiveData<String>()
}