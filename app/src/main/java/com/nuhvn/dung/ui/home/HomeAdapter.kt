package com.nuhvn.dung.ui.home

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nuhvn.dung.R
import com.nuhvn.dung.model.data_model.ProductModel

class HomeAdapter : RecyclerView.Adapter<HomeAdapter.HomeAdapterViewHolder>() {
	private val listData = mutableListOf<ProductModel>()
	inner class HomeAdapterViewHolder(v: View) : RecyclerView.ViewHolder(v){
		fun bindData(item: ProductModel){
		
		}
	}
	
	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeAdapterViewHolder {
		val layoutInflater = parent.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as? LayoutInflater
		return HomeAdapterViewHolder(
			layoutInflater?.inflate(
				R.layout.item_product_medium,
				parent,
				false
			)!!
		)
	}
	
	override fun onBindViewHolder(holder: HomeAdapterViewHolder, position: Int) {
		holder.bindData(listData[position])
	}
	
	override fun getItemCount(): Int = listData.size
}