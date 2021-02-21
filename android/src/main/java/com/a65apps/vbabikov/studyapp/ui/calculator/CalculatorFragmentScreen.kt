package com.a65apps.vbabikov.studyapp.ui.calculator

import com.github.terrakok.cicerone.androidx.FragmentScreen

class CalculatorFragmentScreen : FragmentScreen(
    fragmentCreator = {
        CalculatorFragment.newInstance()
    }
)
