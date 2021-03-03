package com.a65apps.vbabikov.studyapp.calculator

import com.badoo.mvicore.element.Reducer
import java.math.BigDecimal
import java.math.RoundingMode
import java.text.DecimalFormat
import java.text.DecimalFormatSymbols
import java.util.*

class CalculatorReducer : Reducer<CalculatorState, CalculatorEffect> {

    override fun invoke(state: CalculatorState, effect: CalculatorEffect): CalculatorState =
        when (effect) {
            is CalculatorEffect.Input -> state.copy(
                screenText = if (state.requireOverrideInput) {
                    effect.screenTextInput.substring(effect.start until (effect.start + effect.count))
                } else {
                    effect.screenTextInput
                },
                requireOverrideInput = if (screenTextNotChanged(state, effect)) {
                    state.requireOverrideInput
                } else false
            )

            is CalculatorEffect.Add -> state.copy(
                operand1 = effect.operand1,
                pendingOperation = ArithmeticOperations.ADD,
                requireOverrideInput = true
            )

            is CalculatorEffect.Subtract -> state.copy(
                operand1 = effect.operand1,
                pendingOperation = ArithmeticOperations.SUBTRACT,
                requireOverrideInput = true
            )

            is CalculatorEffect.Multiply -> state.copy(
                operand1 = effect.operand1,
                pendingOperation = ArithmeticOperations.MULTIPLY,
                requireOverrideInput = true
            )

            is CalculatorEffect.Divide -> state.copy(
                operand1 = effect.operand1,
                pendingOperation = ArithmeticOperations.DIVIDE,
                requireOverrideInput = true
            )

            is CalculatorEffect.Result -> state.copy(
                screenText = when (state.pendingOperation) {
                    ArithmeticOperations.ADD -> formatResult(
                        state.operand1 + effect.operand2
                    )
                    ArithmeticOperations.SUBTRACT -> formatResult(
                        state.operand1 - effect.operand2
                    )
                    ArithmeticOperations.MULTIPLY -> formatResult(
                        state.operand1 * effect.operand2
                    )
                    ArithmeticOperations.DIVIDE -> formatResult(
                        state.operand1.divide(effect.operand2, 8, RoundingMode.HALF_EVEN)
                    )
                    else -> state.screenText
                },
                requireOverrideInput = true
            )

            CalculatorEffect.Clear -> state.copy(
                operand1 = BigDecimal.ZERO,
                pendingOperation = null,
                screenText = "0",
                requireOverrideInput = true
            )

            is CalculatorEffect.ParseOperand1,
            CalculatorEffect.ParseOperand2 -> state.copy()

            CalculatorEffect.ParseScreenTextError -> state.copy(
                screenText = "Err",
                requireOverrideInput = true
            )
        }

    private fun screenTextNotChanged(
        state: CalculatorState,
        effect: CalculatorEffect.Input
    ) = state.screenText == effect.screenTextInput

    private fun formatResult(result: BigDecimal): String {
        val df = DecimalFormat("#.########")
        df.decimalFormatSymbols = DecimalFormatSymbols.getInstance(Locale.US)
        return df.format(result)
    }
}
