package com.nuhvn.dung.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.nuhvn.dung.base.MyFragment
import com.nuhvn.dung.databinding.FragmentCartBinding
import com.nuhvn.dung.databinding.FragmentHomeBinding
import com.nuhvn.dung.ui.bag.CartFragment

class HomeFragment : MyFragment<FragmentHomeBinding>() {
	private val mViewModel by viewModels<HomeViewModel>()
	
	override fun onCreateView(
		inflater: LayoutInflater,
		container: ViewGroup?,
		savedInstanceState: Bundle?
	): View {
		viewBinding = FragmentHomeBinding.inflate(layoutInflater)
		return viewBinding.root
	}
	
	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)
		viewBinding.apply {
			showTopBar(false)
			showBottomBar(true)
			btnNewOrder.setOnClickListener {
				openFragment(
					CartFragment::class.java,
					Bundle(),
					true
				)
			}
		}
	}
	
	override fun onBack(): Boolean {
		return true
	}
}