package com.example.exchangeapp.utils

import androidx.annotation.AnimRes
import androidx.annotation.IdRes
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import com.example.exchangeapp.R

fun AppCompatActivity.replaceFragment(
    fragment: Fragment,
    @IdRes layoutId: Int = android.R.id.content,
    addToBackStack: Boolean = true,
    tag: String = fragment::class.java.name,
    @AnimRes enter: Int = R.anim.nav_enter,
    @AnimRes exit: Int = R.anim.nav_exit,
    @AnimRes popEnter: Int = R.anim.nav_pop_enter,
    @AnimRes popExit: Int = R.anim.nav_pop_exit
) {
    supportFragmentManager.commit(allowStateLoss = true) {
        setCustomAnimations(enter, exit, popEnter, popExit)
        replace(layoutId, fragment)
        if (addToBackStack) addToBackStack(tag)
    }
}