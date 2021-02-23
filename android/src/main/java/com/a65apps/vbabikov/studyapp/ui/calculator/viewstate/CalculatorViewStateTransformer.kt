package com.a65apps.vbabikov.studyapp.ui.calculator.viewstate

import com.a65apps.vbabikov.studyapp.CalculatorState

class CalculatorViewStateTransformer : (CalculatorState) -> CalculatorViewState {
    override fun invoke(state: CalculatorState) = CalculatorViewState(
        screenText = state.result.toString()
    )
}
