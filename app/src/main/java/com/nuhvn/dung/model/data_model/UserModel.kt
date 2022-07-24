package com.nuhvn.dung.model.data_model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Tbl_User")
class UserModel {
	@PrimaryKey
	var IdUser: Int? = null
}