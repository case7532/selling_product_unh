package com.nuhvn.dung.model.data_model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ProfileModel(
	var id: String? = null,
	var fullName: String? = null,
	var gender: String? = null,
	var dob: String? = null,
	var idNumber: Long? = null,
	var dateIssuance: String? = null
) : Parcelable