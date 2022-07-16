package com.nuhvn.dung.model.data_model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ProductModel(
	val id: String? = null,
	val name: String? = null,
	val description: String? = null,
	val price: String? = null
) : Parcelable