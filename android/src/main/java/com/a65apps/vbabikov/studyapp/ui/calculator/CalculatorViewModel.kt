package com.a65apps.vbabikov.studyapp.ui.calculator

import androidx.lifecycle.ViewModel
import com.github.terrakok.cicerone.Router
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CalculatorViewModel @Inject constructor(
    private val router: Router
) : ViewModel() {
    fun navigateBack() = router.exit()
}
