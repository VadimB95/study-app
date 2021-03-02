package com.a65apps.vbabikov.studyapp

import com.badoo.mvicore.element.PostProcessor

class CalculatorPostProcessor : PostProcessor<CalculatorAction, CalculatorEffect, CalculatorState> {

    override fun invoke(
        action: CalculatorAction,
        effect: CalculatorEffect,
        state: CalculatorState
    ): CalculatorAction? = when (effect) {
        is CalculatorEffect.ParseOperand1 -> CalculatorAction.ParseOperand1(effect.pendingOperation)
        CalculatorEffect.ParseOperand2 -> CalculatorAction.ParseOperand2
        else -> null
    }
}
