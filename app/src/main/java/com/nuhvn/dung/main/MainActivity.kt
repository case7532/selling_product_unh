package com.nuhvn.dung.main

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import com.nuhvn.dung.R
import com.nuhvn.dung.base.MyActivity
import com.nuhvn.dung.base.MyFragment
import com.nuhvn.dung.databinding.ActivityMainBinding
import com.nuhvn.dung.model.database.MyRoomDatabase
import com.nuhvn.dung.ui.bag.CartFragment
import com.nuhvn.dung.ui.category.CategoryFragment
import com.nuhvn.dung.ui.favorite.FavoriteFragment
import com.nuhvn.dung.ui.home.HomeFragment
import com.nuhvn.dung.ui.init_fragment.InitFragment
import com.nuhvn.dung.ui.profile.ProfileFragment
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.runBlocking

class MainActivity : MyActivity<ActivityMainBinding>() {
	private val TAG = "MainActivity"
	private val viewModel by viewModels<MainActivityViewModel>()
	override val containerFragment: Int get() = R.id.fragment_container
	
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		viewBinding = ActivityMainBinding.inflate(layoutInflater)
		setContentView(viewBinding.root)
		openFragment(InitFragment::class.java, Bundle(), false)
		viewBinding.bottomNavigationView.setOnItemSelectedListener { menuItem ->
			when (menuItem.itemId) {
				R.id.nav_home -> {
					showTitleFragment(menuItem.title.toString())
					openFragment(HomeFragment::class.java)
				}
				R.id.nav_category -> {
					showTitleFragment(menuItem.title.toString())
					openFragment(CategoryFragment::class.java)
				}
				R.id.nav_profile -> {
					showTitleFragment(menuItem.title.toString())
					openFragment(ProfileFragment::class.java)
				}
			}
			true
		}
		runBlocking {
			async(Dispatchers.IO) {
				myDataBase = MyRoomDatabase.getInstance(this@MainActivity)
			}.await()
		}
	}
	
	override fun showTitleFragment(value: String) {
		viewBinding.title.text = value
	}
	
	override fun onBack(forceBack: Boolean?): Boolean {
		if(!(supportFragmentManager.findFragmentById(containerFragment) as MyFragment<*>).onBack()){
			with(supportFragmentManager) {
				if (backStackEntryCount > 1) {
					popBackStack()
				}
			}
		}
		return true
	}
	
	fun showTopBar(isShow: Boolean) {
		viewBinding.layoutActionBar.visibility = if (isShow) {
			View.VISIBLE
		} else {
			View.GONE
		}
	}
	
	fun showBottomBar(isShow: Boolean) {
		viewBinding.bottomNavigationView.visibility = if (isShow){
			View.VISIBLE
		} else {
			View.GONE
		}
	}
}