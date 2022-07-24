package com.nuhvn.dung.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.nuhvn.dung.main.MainActivity

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
	
	fun openFragment(
		fragmentClass: Class<out Fragment>,
		args: Bundle = Bundle(),
		addBackStack: Boolean = true
	) {
		(requireActivity() as? MyActivity<*>)?.let {
			it.openFragment(fragmentClass, args, addBackStack)
		}
	}
	
	fun showTopBar(isShow: Boolean) = (requireActivity() as MainActivity).showTopBar(isShow)
	
	fun showBottomBar(isShow: Boolean) = (requireActivity() as MainActivity).showBottomBar(isShow)
	
	abstract fun onBack(): Boolean
}