package com.test.multinavhostdemo.ui.home

import androidx.navigation.fragment.findNavController
import com.test.multinavhostdemo.MobileNavigationDirections
import com.test.multinavhostdemo.R
import com.test.multinavhostdemo.databinding.FragmentHomeChildBinding
import com.test.multinavhostdemo.ui.basefragment.BaseFragment

class HomeChildFragment: BaseFragment<FragmentHomeChildBinding>() {

    override val layoutId: Int
        get() = R.layout.fragment_home_child
    private val args:HomeChildFragmentArgs by lazy {
        HomeChildFragmentArgs.fromBundle(requireArguments())
    }

    override fun initView() {
        binding.text.text= "Home child  ${args.number}"
        binding.btnNext.setOnClickListener {
            findNavController().navigate(MobileNavigationDirections.actionToHomeChild(args.number +1))
        }
    }
}