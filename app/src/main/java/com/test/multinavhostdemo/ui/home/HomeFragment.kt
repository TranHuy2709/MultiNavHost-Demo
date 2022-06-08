package com.test.multinavhostdemo.ui.home

import androidx.navigation.fragment.findNavController
import com.test.multinavhostdemo.MobileNavigationDirections
import com.test.multinavhostdemo.R
import com.test.multinavhostdemo.databinding.FragmentHomeBinding
import com.test.multinavhostdemo.ui.basefragment.BaseFragment

class HomeFragment : BaseFragment<FragmentHomeBinding>(){

    override val layoutId: Int
        get() = R.layout.fragment_home

    override fun initView() {
        binding.btnNext.setOnClickListener {
            findNavController().navigate(MobileNavigationDirections.actionToHomeChild(1))
        }
    }
}