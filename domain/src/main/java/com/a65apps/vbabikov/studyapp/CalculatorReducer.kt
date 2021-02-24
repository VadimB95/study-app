package com.a65apps.vbabikov.studyapp

import com.badoo.mvicore.element.Reducer

class CalculatorReducer : Reducer<CalculatorState, CalculatorWish> {
    override fun invoke(state: CalculatorState, wish: CalculatorWish): CalculatorState =
        when (wish) {
            CalculatorWish.Clear -> state.copy(
                operand1 = 0.0,
                result = 0.0,
                pendingOperation = null
            )
            is CalculatorWish.Add -> state.copy(
                operand1 = wish.operand1,
                result = wish.operand1,
                pendingOperation = CalculatorOperations.ADD
            )
            is CalculatorWish.Result -> state.copy(
                result = when (state.pendingOperation) {
                    CalculatorOperations.ADD -> state.operand1 + wish.operand2
                    else -> state.result
                }
            )

            else -> state
        }
}
