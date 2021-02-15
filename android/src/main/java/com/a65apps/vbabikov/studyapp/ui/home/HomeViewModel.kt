package com.a65apps.vbabikov.studyapp.ui.home

import androidx.lifecycle.ViewModel
import com.a65apps.vbabikov.studyapp.Screens.CalculatorFragmentScreen
import com.github.terrakok.cicerone.Router
import javax.inject.Inject

class HomeViewModel : ViewModel() {
    @Inject
    lateinit var router: Router

    fun navigateToCalculator() = router.navigateTo(CalculatorFragmentScreen())

    fun navigateBack() = router.exit()
}