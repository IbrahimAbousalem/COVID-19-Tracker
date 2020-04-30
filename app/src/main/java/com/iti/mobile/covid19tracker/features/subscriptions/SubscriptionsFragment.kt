package com.iti.mobile.covid19tracker.features.subscriptions

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.iti.mobile.covid19tracker.R
import com.iti.mobile.covid19tracker.databinding.FragmentSubscriptionsBinding

/**
 * A simple [Fragment] subclass.
 */
class SubscriptionsFragment : Fragment() {
lateinit var binding: FragmentSubscriptionsBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentSubscriptionsBinding.inflate(layoutInflater)
        return binding.root
    }

}
