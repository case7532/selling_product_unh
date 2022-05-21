package com.nuhvn.dung.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding

abstract class MyFragment<VB : ViewBinding> : Fragment() {
	lateinit var viewBinding: VB
	override fun onCreateView(
		inflater: LayoutInflater,
		container: ViewGroup?,
		savedInstanceState: Bundle?
	): View? {
		return viewBinding.root
	}
	
	fun showLoading(content: String? = null) {
		(requireActivity() as MyActivity<*>).showLoading(content)
	}
	
	fun hideLoading() = (requireActivity() as MyActivity<*>).hideLoading()
	
	fun openFragment(fragmentClass: Class<out Fragment>, args: Bundle = Bundle(), addBackStack: Boolean = true) {
		(requireActivity() as? MyActivity<*>)?.let {
			it.openFragment(fragmentClass, args, addBackStack)
		}
	}
}