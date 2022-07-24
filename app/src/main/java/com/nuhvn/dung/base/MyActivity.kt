package com.nuhvn.dung.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import androidx.viewbinding.ViewBinding
import com.nuhvn.dung.R
import com.nuhvn.dung.model.database.MyRoomDatabase

abstract class MyActivity<VB : ViewBinding> : AppCompatActivity() {
	lateinit var viewBinding: VB
	var loading: MyAlert? = null
	abstract val containerFragment: Int
	lateinit var myDataBase: MyRoomDatabase
	
	abstract fun onBack(forceBack: Boolean? = false): Boolean
	override fun onBackPressed() {
		if (!onBack()) super.onBackPressed()
	}
	
	fun showLoading(content: String?) {
		loading ?: MyAlert.create(
			contentProgress = content,
			type = MyAlert.KEY_SHOW_LOADING
		).apply {
			loading = this
		}
		loading?.show(supportFragmentManager, MyAlert.TAG)
	}
	
	abstract fun showTitleFragment(value: String)
	fun hideLoading() {
		loading?.dismissAllowingStateLoss()
	}
	
	fun openFragment(
		fragmentClass: Class<out Fragment>,
		args: Bundle = Bundle(),
		addBackStack: Boolean = true
	) {
		supportFragmentManager
			.commit {
				replace(containerFragment, fragmentClass, args)
				addToBackStack(fragmentClass.simpleName)
				setReorderingAllowed(addBackStack)
			}
	}
}