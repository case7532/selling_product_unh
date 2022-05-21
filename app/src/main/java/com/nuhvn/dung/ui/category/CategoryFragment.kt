package com.nuhvn.dung.ui.category

import android.os.Bundle
import com.nuhvn.dung.base.MyFragment
import com.nuhvn.dung.databinding.FragmentCategoryBinding

class CategoryFragment : MyFragment<FragmentCategoryBinding>() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		viewBinding = FragmentCategoryBinding.inflate(layoutInflater)
	}
}