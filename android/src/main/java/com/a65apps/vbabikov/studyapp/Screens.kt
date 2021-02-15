package com.a65apps.vbabikov.studyapp

import android.content.Intent
import com.a65apps.vbabikov.studyapp.ui.CalculatorFragment
import com.a65apps.vbabikov.studyapp.ui.HomeFragment
import com.a65apps.vbabikov.studyapp.ui.MainActivity
import com.github.terrakok.cicerone.androidx.ActivityScreen
import com.github.terrakok.cicerone.androidx.FragmentScreen

/**
 * Created by Konstantin Tskhovrebov (aka @terrakok)
 * on 11.10.16
 */
object Screens {

    fun MainActivityScreen() = ActivityScreen {
        Intent(it, MainActivity::class.java)
    }

    fun HomeFragmentScreen() = FragmentScreen {
        HomeFragment()
    }

    fun CalculatorFragmentScreen() = FragmentScreen {
        CalculatorFragment()
    }

//    val Forward(containerName: String, number: Int) = FragmentScreen {
//        ForwardFragment.getNewInstance(containerName, number)
//    }
}