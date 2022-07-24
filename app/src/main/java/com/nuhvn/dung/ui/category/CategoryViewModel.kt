package com.nuhvn.dung.ui.category

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nuhvn.dung.model.data_model.SanPhamModel
import com.nuhvn.dung.model.database.MyRoomDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class CategoryViewModel : ViewModel() {
	val listProduct = MutableLiveData<List<SanPhamModel>>()
	fun getListProduct(context: Context) {
		viewModelScope.launch {
			var list = listOf<SanPhamModel>()
			async(Dispatchers.IO) {
				list =
					MyRoomDatabase.getInstance(context).sanPhamDao().getAllData().value ?: listOf()
			}.await()
			listProduct.postValue(list)
		}
	}
}