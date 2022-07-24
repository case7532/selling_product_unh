package com.nuhvn.dung.model.data_model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Tbl_GioHang")
class GioHangModel {
	@PrimaryKey(autoGenerate = true)
	var IdHoaDon: Int? = null
	var IdSP: Int? = null
	var SoLuongSP: String? = null
}