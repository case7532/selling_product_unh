package com.nuhvn.dung.model.data_model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Tbl_Account")
class AccountModel {
	@PrimaryKey(autoGenerate = true)
	var accountId: Int? = null
	var username: String? = null
	var password: String? = null
	var userId: String? = null
}