package com.a65apps.vbabikov.studyapp.calculator

sealed class CalculatorAction {

    data class Input(
        val screenTextInput: String,
        val start: Int,
        val count: Int
    ) : CalculatorAction()

    object Add : CalculatorAction()

    object Subtract : CalculatorAction()

    object Multiply : CalculatorAction()

    object Divide : CalculatorAction()

    object Result : CalculatorAction()

    object Clear : CalculatorAction()

    data class ParseOperand1(val pendingOperation: ArithmeticOperations) : CalculatorAction()

    object ParseOperand2 : CalculatorAction()
}
