package com.a65apps.vbabikov.studyapp.ui.calculator.viewstate

import com.a65apps.vbabikov.studyapp.calculator.CalculatorState
import javax.inject.Inject

class CalculatorViewStateTransformer @Inject constructor() :
        (CalculatorState) -> CalculatorViewState {
    override fun invoke(state: CalculatorState) = CalculatorViewState(
        screenText = state.screenText
    )
}
