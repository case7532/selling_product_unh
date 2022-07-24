package com.nuhvn.dung.ui.profile

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.nuhvn.dung.base.MyFragment
import com.nuhvn.dung.databinding.FragmentProfileBinding

class ProfileFragment : MyFragment<FragmentProfileBinding>() {
	private val mViewModel by viewModels<ProfileViewModel>()
	
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		viewBinding = FragmentProfileBinding.inflate(layoutInflater)
	}
	
	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)
	}
	
	override fun onBack(): Boolean = false
}