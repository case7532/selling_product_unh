package com.nuhvn.dung.ui.category

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.nuhvn.dung.base.MyFragment
import com.nuhvn.dung.databinding.FragmentCategoryBinding
import com.nuhvn.dung.model.database.MyRoomDatabase

class CategoryFragment : MyFragment<FragmentCategoryBinding>() {
	private val viewModel by viewModels<CategoryViewModel>()
	private var adapter: CategoryAdapter? = null
	override fun onCreateView(
		inflater: LayoutInflater,
		container: ViewGroup?,
		savedInstanceState: Bundle?
	): View? {
		viewBinding = FragmentCategoryBinding.inflate(layoutInflater)
		return viewBinding.root
	}
	
	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)
		viewBinding.apply {
			CategoryAdapter {
				//TODO: go to detail product
			}.apply {
				adapter = this
				rvProductList.adapter = adapter
			}
			viewModel.getListProduct(requireContext())
			viewModel.listProduct.observe(viewLifecycleOwner, Observer {
				it?.let {
					adapter?.updateData(it)
				}
			})
		}
	}
	
	override fun onBack(): Boolean = false
}