package com.a65apps.vbabikov.studyapp

import com.badoo.mvicore.element.Reducer

class CalculatorReducer : Reducer<CalculatorState, CalculatorWish> {
    override fun invoke(state: CalculatorState, wish: CalculatorWish): CalculatorState = when (wish) {
        CalculatorWish.Clear -> state.copy(
            operand1 = 0.0,
            result = 0.0
        )
        else -> state
    }
}
