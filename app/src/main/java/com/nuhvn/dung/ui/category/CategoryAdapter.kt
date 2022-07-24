package com.nuhvn.dung.ui.category

import android.content.Context
import android.graphics.BitmapFactory
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.nuhvn.dung.databinding.ItemProductBinding
import com.nuhvn.dung.model.data_model.SanPhamModel

class CategoryAdapter(
	private var itemClickCallBack: (SanPhamModel) -> Unit
) : RecyclerView.Adapter<CategoryAdapter.CategoryAdapterViewHolder>() {
	private val data = mutableListOf<SanPhamModel>()
	private lateinit var context: Context
	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryAdapterViewHolder {
		context = parent.context
		val layoutInflater = LayoutInflater.from(context)
		return CategoryAdapterViewHolder(
			ItemProductBinding.inflate(layoutInflater, parent, false)
		)
	}
	
	override fun onBindViewHolder(holder: CategoryAdapterViewHolder, position: Int) {
		holder.bindData(data[position])
	}
	
	override fun getItemCount(): Int = data.size
	
	inner class CategoryAdapterViewHolder(private var binding: ItemProductBinding) : RecyclerView.ViewHolder(
		binding.root
	) {
		fun bindData(item: SanPhamModel) {
			binding.apply {
				item.HinhAnhSP?.let {
					val byteImage = it.toByteArray()
					val bitmap = BitmapFactory.decodeByteArray(byteImage, 0, byteImage.size)
					Glide.with(context).load(bitmap).into(ivProductImage)
				}
				tvProductName.text = item.TenSP
				tvProductDescription.text = item.IdSP.toString()
				tvProductPrice.text = item.GiaSP
			}
			itemView.setOnClickListener {
				itemClickCallBack.invoke(item)
			}
		}
	}
	
	fun updateData(data: List<SanPhamModel>){
		this.data.clear()
		this.data.addAll(data)
		notifyDataSetChanged()
	}
}

