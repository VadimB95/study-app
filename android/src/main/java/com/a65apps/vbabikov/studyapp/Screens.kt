package com.a65apps.vbabikov.studyapp

import android.content.Intent
import com.a65apps.vbabikov.studyapp.ui.MainActivity
import com.a65apps.vbabikov.studyapp.ui.calculator.CalculatorFragment
import com.a65apps.vbabikov.studyapp.ui.home.HomeFragment
import com.github.terrakok.cicerone.androidx.ActivityScreen
import com.github.terrakok.cicerone.androidx.FragmentScreen

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
}