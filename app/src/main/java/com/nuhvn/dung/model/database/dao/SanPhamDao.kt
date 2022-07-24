package com.nuhvn.dung.model.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import com.nuhvn.dung.model.data_model.SanPhamModel

@Dao
abstract class SanPhamDao {
	
	@Query("SELECT * FROM tbl_sanpham")
	abstract fun getAllData(): LiveData<List<SanPhamModel>>
}