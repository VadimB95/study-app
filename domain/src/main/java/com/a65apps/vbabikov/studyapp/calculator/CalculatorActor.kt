package com.a65apps.vbabikov.studyapp.calculator

import com.badoo.mvicore.element.Actor
import io.reactivex.Observable

class CalculatorActor : Actor<CalculatorState, CalculatorAction, CalculatorEffect> {

    override fun invoke(
        state: CalculatorState,
        action: CalculatorAction
    ): Observable<CalculatorEffect> = when (action) {

        is CalculatorAction.Input -> Observable.just(
            CalculatorEffect.Input(
                screenTextInput = action.screenTextInput,
                count = action.count,
                start = action.start
            )
        )

        is CalculatorAction.ParseOperand1 -> {
            try {
                val parsedOperand1 = state.screenText.toBigDecimal()

                when (action.pendingOperation) {
                    ArithmeticOperations.ADD -> Observable.just(
                        CalculatorEffect.Add(parsedOperand1)
                    )
                    ArithmeticOperations.SUBTRACT -> Observable.just(
                        CalculatorEffect.Subtract(parsedOperand1)
                    )
                    ArithmeticOperations.MULTIPLY -> Observable.just(
                        CalculatorEffect.Multiply(parsedOperand1)
                    )
                    ArithmeticOperations.DIVIDE -> Observable.just(
                        CalculatorEffect.Divide(parsedOperand1)
                    )
                }
            } catch (e: NumberFormatException) {
                Observable.just(CalculatorEffect.ParseScreenTextError)
            }
        }

        CalculatorAction.ParseOperand2 -> {
            try {
                val parsedOperand2 = state.screenText.toBigDecimal()
                Observable.just(CalculatorEffect.Result(parsedOperand2))
            } catch (e: NumberFormatException) {
                Observable.just(CalculatorEffect.ParseScreenTextError)
            }
        }

        CalculatorAction.Add -> Observable.just(
            CalculatorEffect.ParseOperand1(ArithmeticOperations.ADD)
        )
        CalculatorAction.Subtract -> Observable.just(
            CalculatorEffect.ParseOperand1(ArithmeticOperations.SUBTRACT)
        )
        CalculatorAction.Multiply -> Observable.just(
            CalculatorEffect.ParseOperand1(ArithmeticOperations.MULTIPLY)
        )
        CalculatorAction.Divide -> Observable.just(
            CalculatorEffect.ParseOperand1(ArithmeticOperations.DIVIDE)
        )
        CalculatorAction.Clear -> Observable.just(
            CalculatorEffect.Clear
        )
        CalculatorAction.Result -> Observable.just(
            CalculatorEffect.ParseOperand2
        )
    }
}
