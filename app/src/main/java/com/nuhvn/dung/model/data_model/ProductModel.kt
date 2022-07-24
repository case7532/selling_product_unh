package com.nuhvn.dung.model.data_model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity(tableName = "tbl_product")
@Parcelize
data class ProductModel(
	@PrimaryKey(autoGenerate = true) val id: Int? = null,
	val name: String? = null,
	val description: String? = null,
	val price: String? = null,
	var image64: String? = null
) : Parcelable