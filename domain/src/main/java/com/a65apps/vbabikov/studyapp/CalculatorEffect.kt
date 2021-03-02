package com.a65apps.vbabikov.studyapp

sealed class CalculatorEffect {

    data class Input(
        val screenTextInput: String,
        val start: Int,
        val count: Int
    ) : CalculatorEffect()

    data class Add(val operand1: Double) : CalculatorEffect()

    data class Subtract(val operand1: Double) : CalculatorEffect()

    data class Multiply(val operand1: Double) : CalculatorEffect()

    data class Divide(val operand1: Double) : CalculatorEffect()

    data class Result(val operand2: Double) : CalculatorEffect()

    object Clear : CalculatorEffect()

    data class ParseOperand1(val pendingOperation: ArithmeticOperations) : CalculatorEffect()

    object ParseOperand2 : CalculatorEffect()

    object ParseScreenTextError : CalculatorEffect()
}
