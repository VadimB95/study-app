package com.a65apps.vbabikov.studyapp.ui.calculator.event

import com.a65apps.vbabikov.studyapp.CalculatorWish

class CalculatorUiEventTransformer : (CalculatorUiEvent) -> CalculatorWish {
    override fun invoke(event: CalculatorUiEvent): CalculatorWish = when (event) {
        CalculatorUiEvent.Clear -> CalculatorWish.Clear
        else -> CalculatorWish.Clear
    }
}
