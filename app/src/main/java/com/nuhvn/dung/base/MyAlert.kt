package com.nuhvn.dung.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.nuhvn.dung.R
import com.nuhvn.dung.databinding.AlertBinding

/**
 * Show alert
 */
class MyAlert : DialogFragment() {
	companion object {
		private var INSTANCE: MyAlert? = null
		
		const val TAG = "Alert fragment dialog"
		const val KEY_TITLE = "alert.title"
		const val KEY_CONTENT = "alert.content"
		const val KEY_PROGRESS_CONTENT = "alert.content.progress"
		const val KEY_IMAGE = "alert.image"
		const val KEY_SHOW_LOADING = "alert.show.loading"
		const val KEY_SHOW_CONTENT = "alert.show.content"
		
		fun create(
			type: String = "",
			title: String? = "",
			content: String? = "",
			contentProgress: String? = "",
			resImage: Int? = null
		): MyAlert {
			return INSTANCE ?: MyAlert().apply {
				arguments = Bundle().apply {
					putString(KEY_TITLE, title)
					putString(KEY_CONTENT, content)
					putString(KEY_PROGRESS_CONTENT, contentProgress)
					putInt(KEY_IMAGE, resImage ?: -1)
					putBoolean(type, true)
				}
				INSTANCE = this
			}
		}
	}
	
	private lateinit var viewBinding: AlertBinding
	private var title: String? = ""
	private var content: String? = ""
	private var progressContent: String? = ""
	private var resImage: Int? = -1
	
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		viewBinding = AlertBinding.inflate(layoutInflater)
	}
	
	override fun onCreateView(
		inflater: LayoutInflater,
		container: ViewGroup?,
		savedInstanceState: Bundle?
	): View = viewBinding.root
	
	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)
		arguments?.apply {
			title = getString(KEY_TITLE)
			content = getString(KEY_CONTENT)
			progressContent = if(getString(KEY_PROGRESS_CONTENT).isNullOrEmpty()){
				getString(R.string.loading_content)
			} else {
				getString(KEY_PROGRESS_CONTENT)
			}
			resImage = getInt(KEY_IMAGE)
			if (getBoolean(KEY_SHOW_LOADING)) {
				with(viewBinding) {
					layoutLoadding.visibility = View.VISIBLE
					txtProgressContent.text = progressContent
				}
				
			} else if (getBoolean(KEY_SHOW_CONTENT)) {
				with(viewBinding) {
					layoutAlert.visibility = View.VISIBLE
					txtContent.text = content
					txtTitle.text = title
					imgAlert.setImageResource(resImage!!)
				}
			}
		}
	}
	
	override fun onStart() {
		super.onStart()
		dialog?.setCanceledOnTouchOutside(false)
	}
}