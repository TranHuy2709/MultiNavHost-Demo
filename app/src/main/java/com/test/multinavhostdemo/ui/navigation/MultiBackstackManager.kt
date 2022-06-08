package com.test.multinavhostdemo.ui.navigation

import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.test.multinavhostdemo.MainActivity
import com.test.multinavhostdemo.R

class MultiBackstackManager(val activity: MainActivity) {
    private  var homeController:NavController?= null
    private  var dashboardController:NavController?= null
    private  var notificationController:NavController?= null

    init {
        initHomeController()
        initDashboardController()
        initNotificationController()
    }

    fun getHomeController():NavController{
        return homeController!!
    }

    fun getDashboardController():NavController{
        return dashboardController!!
    }

    fun getNotificationController():NavController{
        return notificationController!!
    }

    private fun initHomeController(){
        homeController=Navigation.findNavController(activity, R.id.home_nav_host_fragment)
        val navGraph=homeController!!.navInflater.inflate(R.navigation.mobile_navigation)
        navGraph.setStartDestination(R.id.navigation_home)
        homeController!!.graph = navGraph
    }

    private fun initDashboardController(){
        dashboardController=Navigation.findNavController(activity, R.id.dashboard_nav_host_fragment)
        val navGraph=dashboardController!!.navInflater.inflate(R.navigation.mobile_navigation)
        navGraph.setStartDestination(R.id.navigation_dashboard)
        dashboardController!!.graph = navGraph
    }

    private fun initNotificationController(){
        notificationController=Navigation.findNavController(activity, R.id.notification_nav_host_fragment)
        val navGraph=notificationController!!.navInflater.inflate(R.navigation.mobile_navigation)
        navGraph.setStartDestination(R.id.navigation_notifications)
        notificationController!!.graph = navGraph
    }

}