package com.a65apps.vbabikov.studyapp.ui.calculator

import androidx.lifecycle.ViewModel
import com.github.terrakok.cicerone.Router
import javax.inject.Inject

class CalculatorViewModel : ViewModel() {
    @Inject
    lateinit var router: Router

    fun navigateBack() = router.exit()
}