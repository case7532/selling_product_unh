package com.nuhvn.dung.ui.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.nuhvn.dung.base.MyFragment
import com.nuhvn.dung.databinding.FragmentLoginBinding
import com.nuhvn.dung.ui.home.HomeFragment

class LoginFragment: MyFragment<FragmentLoginBinding>() {
	override fun onCreateView(
		inflater: LayoutInflater,
		container: ViewGroup?,
		savedInstanceState: Bundle?
	): View? {
		viewBinding = FragmentLoginBinding.inflate(inflater, container, false)
		return viewBinding.root
	}
	
	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)
		viewBinding.apply {
			showTopBar(false)
			showBottomBar(false)
			btnLogin.setOnClickListener {
				openFragment(
					HomeFragment::class.java,
					Bundle(),
					false
				)
			}
		}
	}
	
	override fun onBack(): Boolean {
		requireActivity().finish()
		return true
	}
}