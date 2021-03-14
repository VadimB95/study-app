package com.a65apps.vbabikov.studyapp.calculator

import com.badoo.mvicore.element.Reducer
import java.math.BigDecimal
import java.math.RoundingMode
import java.text.DecimalFormat
import java.text.DecimalFormatSymbols
import java.util.Locale

class CalculatorReducer : Reducer<CalculatorState, CalculatorEffect> {
    private val decimalFormat = object : ThreadLocal<DecimalFormat>() {
        override fun initialValue() = DecimalFormat("#.########").apply {
            decimalFormatSymbols = DecimalFormatSymbols.getInstance(Locale.US)
        }

    }

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
                    ArithmeticOperations.ADD -> decimalFormat.get().format(
                        state.operand1 + effect.operand2
                    )
                    ArithmeticOperations.SUBTRACT -> decimalFormat.get().format(
                        state.operand1 - effect.operand2
                    )
                    ArithmeticOperations.MULTIPLY -> decimalFormat.get().format(
                        state.operand1 * effect.operand2
                    )
                    ArithmeticOperations.DIVIDE -> decimalFormat.get().format(
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

            CalculatorEffect.ParseScreenTextError -> state.copy(
                screenText = "Err",
                requireOverrideInput = true
            )

            is CalculatorEffect.ParseOperand1,
            CalculatorEffect.ParseOperand2 -> state
        }

    private fun screenTextNotChanged(
        state: CalculatorState,
        effect: CalculatorEffect.Input
    ) = state.screenText == effect.screenTextInput

//    private fun formatResult(result: BigDecimal) =
//        DecimalFormat("#.########").run {
//            decimalFormatSymbols = DecimalFormatSymbols.getInstance(Locale.US)
//            format(result)
//        }
}
