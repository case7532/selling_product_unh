package com.nuhvn.dung.model.firebase

import android.util.Log
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class MyFirebase {
	private val TAG = "Firebase"
	private val database = Firebase.database
	
	companion object {
		private var INSTANCE: MyFirebase? = null
		fun getInstance(): MyFirebase = INSTANCE ?: MyFirebase().apply {
			INSTANCE = this
		}
	}
	
	fun onDataProfileChange() {
		database.getReference(MyFirebaseReference.REFERENCE_PROFILE)
			.addValueEventListener(
				object : ValueEventListener {
					override fun onDataChange(snapshot: DataSnapshot) {
						Log.d(TAG, "Profile change")
						
					}
					
					override fun onCancelled(error: DatabaseError) {
						Log.e(TAG, error.message)
					}
				}
			)
	}
}