package com.nuhvn.dung.ui.confirmOrder

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.nuhvn.dung.base.MyFragment
import com.nuhvn.dung.databinding.FragmentConfirmOrderBinding

class ConfirmOrderFragment: MyFragment<FragmentConfirmOrderBinding>() {
	override fun onCreateView(
		inflater: LayoutInflater,
		container: ViewGroup?,
		savedInstanceState: Bundle?
	): View? {
		viewBinding = FragmentConfirmOrderBinding.inflate(inflater, container, false)
		return viewBinding.root
	}
	
	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)
		viewBinding.apply {
		
		}
	}
	
	override fun onBack(): Boolean = false
}