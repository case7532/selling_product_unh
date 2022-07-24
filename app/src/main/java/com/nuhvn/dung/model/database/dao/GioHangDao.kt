package com.nuhvn.dung.model.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import androidx.room.Update
import com.nuhvn.dung.model.data_model.GioHangModel

@Dao
abstract class GioHangDao {
	
	@Query("SELECT * FROM Tbl_GioHang WHERE Tbl_GioHang.IdHoaDon = :id")
	abstract fun getById(id: String): LiveData<List<GioHangModel>>
	
	@Update(onConflict = REPLACE)
	abstract fun update(data: GioHangModel)
	
}