package com.nuhvn.dung.ui.bag

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.nuhvn.dung.base.MyFragment
import com.nuhvn.dung.databinding.FragmentBagBinding

class BagFragment : MyFragment<FragmentBagBinding>(){
	private val mViewModel by viewModels<BagViewModel>()
	
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		viewBinding = FragmentBagBinding.inflate(layoutInflater)
	}
	
	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)
	}
}