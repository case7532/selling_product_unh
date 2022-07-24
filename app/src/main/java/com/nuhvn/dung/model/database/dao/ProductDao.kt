package com.nuhvn.dung.model.database.dao

import android.database.Observable
import androidx.room.Dao
import androidx.room.Query
import com.nuhvn.dung.model.data_model.ProductModel

@Dao
interface ProductDao {
	@Query("SELECT * FROM tbl_product")
	fun getAll(): Observable<List<ProductModel>>
}