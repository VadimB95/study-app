package com.a65apps.vbabikov.studyapp

import android.content.Intent
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

//    val Forward(containerName: String, number: Int) = FragmentScreen {
//        ForwardFragment.getNewInstance(containerName, number)
//    }
}