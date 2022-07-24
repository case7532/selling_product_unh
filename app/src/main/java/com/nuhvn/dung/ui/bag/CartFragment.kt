package com.nuhvn.dung.ui.bag

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.nuhvn.dung.base.MyFragment
import com.nuhvn.dung.databinding.FragmentCartBinding

class CartFragment : MyFragment<FragmentCartBinding>() {
	private val mViewModel by viewModels<CartViewModel>()
	
	override fun onCreateView(
		inflater: LayoutInflater,
		container: ViewGroup?,
		savedInstanceState: Bundle?
	): View {
		viewBinding = FragmentCartBinding.inflate(layoutInflater)
		return viewBinding.root
	}
	
	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)
	}
	
	override fun onBack(): Boolean = false
}