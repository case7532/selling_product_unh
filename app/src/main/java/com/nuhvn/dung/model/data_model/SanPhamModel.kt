package com.nuhvn.dung.model.data_model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Tbl_SanPham")
class SanPhamModel {
	@PrimaryKey(autoGenerate = true)
	var IdSP: Int? = null
	var TenSP: String? = null
	var GiaSP: String? = null
	var HinhAnhSP: String? = null
}