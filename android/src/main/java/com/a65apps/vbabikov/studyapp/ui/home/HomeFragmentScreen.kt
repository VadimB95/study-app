package com.a65apps.vbabikov.studyapp.ui.home

import com.github.terrakok.cicerone.androidx.FragmentScreen

class HomeFragmentScreen : FragmentScreen(
    fragmentCreator = {
        HomeFragment.newInstance()
    }
)
