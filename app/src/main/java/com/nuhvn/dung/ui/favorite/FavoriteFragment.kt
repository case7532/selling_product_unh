package com.nuhvn.dung.ui.favorite

import android.os.Bundle
import com.nuhvn.dung.base.MyFragment
import com.nuhvn.dung.databinding.FragmentFavoriteBinding

class FavoriteFragment : MyFragment<FragmentFavoriteBinding>() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		viewBinding = FragmentFavoriteBinding.inflate(layoutInflater)
	}
	
	override fun onBack(): Boolean  = false
}