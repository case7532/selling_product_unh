package com.nuhvn.dung.main

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.viewModels
import com.nuhvn.dung.R
import com.nuhvn.dung.base.MyActivity
import com.nuhvn.dung.databinding.ActivityMainBinding
import com.nuhvn.dung.ui.bag.BagFragment
import com.nuhvn.dung.ui.category.CategoryFragment
import com.nuhvn.dung.ui.favorite.FavoriteFragment
import com.nuhvn.dung.ui.home.HomeFragment
import com.nuhvn.dung.ui.init_fragment.InitFragment
import com.nuhvn.dung.ui.profile.ProfileFragment

class MainActivity : MyActivity<ActivityMainBinding>() {
	private val TAG = "MainActivity"
	private val viewModel by viewModels<MainActivityViewModel>()
	override val containerFragment: Int get() = R.id.fragment_container
	
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		viewBinding = ActivityMainBinding.inflate(layoutInflater)
		setContentView(viewBinding.root)
		openFragment(InitFragment::class.java, Bundle(), false)
		supportFragmentManager.addOnBackStackChangedListener {
			Log.d(TAG, "onBackStackChange")
			when(supportFragmentManager.findFragmentById(containerFragment)){
				is InitFragment -> {
					viewBinding.bottomNavigationView.visibility = View.GONE
					viewBinding.layoutActionBar.visibility = View.GONE
					
				}
				else -> {
					viewBinding.bottomNavigationView.visibility = View.VISIBLE
					viewBinding.layoutActionBar.visibility = View.VISIBLE
				}
			}
		}
		viewBinding.bottomNavigationView.setOnItemSelectedListener { menuItem ->
			when (menuItem.itemId) {
				R.id.nav_home -> {
					showTitleFragment(menuItem.title.toString())
					openFragment(HomeFragment::class.java)
				}
				R.id.nav_bag -> {
					showTitleFragment(menuItem.title.toString())
					openFragment(BagFragment::class.java)
				}
				R.id.nav_category -> {
					showTitleFragment(menuItem.title.toString())
					openFragment(CategoryFragment::class.java)
				}
				R.id.nav_favorite -> {
					showTitleFragment(menuItem.title.toString())
					openFragment(FavoriteFragment::class.java)
				}
				R.id.nav_profile -> {
					showTitleFragment(menuItem.title.toString())
					openFragment(ProfileFragment::class.java)
				}
			}
			true
		}
	}
	
	override fun showTitleFragment(value: String) {
		viewBinding.title.text = value
	}
	
	override fun onBack(forceBack: Boolean?): Boolean {
		with(supportFragmentManager){
			if (backStackEntryCount > 1){
				popBackStack()
			}
		}
		return true
	}
}