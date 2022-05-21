package com.nuhvn.dung.ui.init_fragment

import android.os.Bundle
import android.view.View
import com.nuhvn.dung.base.MyActivity
import com.nuhvn.dung.base.MyFragment
import com.nuhvn.dung.databinding.FragmentInitBinding
import com.nuhvn.dung.ui.home.HomeFragment
import com.nuhvn.dung.ui.profile.ProfileFragment
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class InitFragment : MyFragment<FragmentInitBinding>() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		viewBinding = FragmentInitBinding.inflate(layoutInflater)
	}
	
	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)
		GlobalScope.launch {
			showLoading()
			delay(10000L)
			hideLoading()
			openFragment(HomeFragment::class.java)
			(requireActivity() as? MyActivity<*>)?.showTitleFragment("Home")
		}
	}
}