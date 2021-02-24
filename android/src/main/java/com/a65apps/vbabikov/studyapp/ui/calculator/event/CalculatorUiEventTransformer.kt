package com.a65apps.vbabikov.studyapp.ui.calculator.event

import com.a65apps.vbabikov.studyapp.CalculatorWish
import javax.inject.Inject

class CalculatorUiEventTransformer @Inject constructor() :
        (CalculatorUiEvent) -> CalculatorWish {
    override fun invoke(event: CalculatorUiEvent): CalculatorWish = when (event) {
        is CalculatorUiEvent.Add -> CalculatorWish.Add(event.operand1)
        is CalculatorUiEvent.Result -> CalculatorWish.Result(event.operand2)
        CalculatorUiEvent.Clear -> CalculatorWish.Clear
        else -> CalculatorWish.Clear
    }
}
