package com.test.multinavhostdemo

import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationBarView
import com.test.multinavhostdemo.databinding.ActivityMainBinding
import com.test.multinavhostdemo.ui.navigation.MultiBackstackManager

class MainActivity : AppCompatActivity(), NavigationBarView.OnItemSelectedListener, NavigationBarView.OnItemReselectedListener {

    private lateinit var binding: ActivityMainBinding
    private val bottomNavigationView:BottomNavigationView by lazy {
        binding.navView
    }
    private val multiBackstackManager:MultiBackstackManager by lazy {
        MultiBackstackManager(this)
    }
    private var navController:NavController?=null
    private var  navHostFragment: NavHostFragment?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        bottomNavigationView.setOnItemSelectedListener(this)
        bottomNavigationView.setOnItemReselectedListener(this)
        initHomeNavigation()
    }

    private fun initHomeNavigation(){
        navController= multiBackstackManager.getHomeController()
        navHostFragment= supportFragmentManager.findFragmentById(R.id.home_nav_host_fragment) as NavHostFragment
        binding.curNavigation=0
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.navigation_home->{
                binding.curNavigation= HOME_TAB
                navController= multiBackstackManager.getHomeController()
                navHostFragment= supportFragmentManager.findFragmentById(R.id.home_nav_host_fragment) as NavHostFragment
            }
            R.id.navigation_dashboard->{
                binding.curNavigation= DASHBOARD_TAB
                navController= multiBackstackManager.getDashboardController()
                navHostFragment= supportFragmentManager.findFragmentById(R.id.dashboard_nav_host_fragment) as NavHostFragment
            }
            R.id.navigation_notifications->{
                binding.curNavigation= NOTIFICATION_TAB
                navController= multiBackstackManager.getNotificationController()
                navHostFragment= supportFragmentManager.findFragmentById(R.id.notification_nav_host_fragment) as NavHostFragment
            }
        }
        return true
    }

    override fun onNavigationItemReselected(item: MenuItem) {
        //do nothing
    }

    override fun onBackPressed() {
        val navHostSize= navHostFragment!!.childFragmentManager.backStackEntryCount
        val navControllerSize= navController!!.backQueue.size
        if (navHostSize>0){
            navController!!.popBackStack()
        }else{
            super.onBackPressed()
        }
    }

    companion object{
        private const val HOME_TAB=0
        private const val DASHBOARD_TAB=1
        private const val NOTIFICATION_TAB=2
    }


}