package com.nuhvn.dung.ui.payment

import androidx.fragment.app.viewModels
import com.nuhvn.dung.base.MyFragment
import com.nuhvn.dung.databinding.FragmentPaymentBinding

class PaymentFragment : MyFragment<FragmentPaymentBinding>(){
	private val vm by viewModels<PaymentViewModel>()
}