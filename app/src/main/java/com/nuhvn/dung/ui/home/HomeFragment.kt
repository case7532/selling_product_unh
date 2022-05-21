package com.nuhvn.dung.ui.home

import android.os.Bundle
import com.nuhvn.dung.base.MyFragment
import com.nuhvn.dung.databinding.FragmentHomeBinding

class HomeFragment : MyFragment<FragmentHomeBinding>() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		viewBinding = FragmentHomeBinding.inflate(layoutInflater)
	}
}