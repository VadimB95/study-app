package com.a65apps.vbabikov.studyapp.ui.home

import androidx.lifecycle.ViewModel
import com.a65apps.vbabikov.studyapp.ui.calculator.CalculatorFragmentScreen
import com.github.terrakok.cicerone.Router
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val router: Router
) : ViewModel() {

    fun navigateToCalculator() = router.navigateTo(CalculatorFragmentScreen())

    fun navigateBack() = router.exit()
}
