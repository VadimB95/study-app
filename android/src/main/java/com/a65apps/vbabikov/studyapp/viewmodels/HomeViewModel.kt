package com.a65apps.vbabikov.studyapp.viewmodels

import androidx.lifecycle.ViewModel
import com.a65apps.vbabikov.studyapp.Screens.CalculatorFragmentScreen
import com.a65apps.vbabikov.studyapp.StudyApplication
import com.github.terrakok.cicerone.Router
import javax.inject.Inject

class HomeViewModel : ViewModel() {
    @Inject
    lateinit var router: Router

    init {
        StudyApplication.INSTANCE.appComponent.inject(this)
    }

    fun navigateToCalc() = router.navigateTo(CalculatorFragmentScreen())
}