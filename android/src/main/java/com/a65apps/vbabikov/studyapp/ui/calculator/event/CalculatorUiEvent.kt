package com.a65apps.vbabikov.studyapp.ui.calculator.event

sealed class CalculatorUiEvent {

    data class Add(val operand1: Double) : CalculatorUiEvent()

    data class Subtract(val operand1: Double) : CalculatorUiEvent()

    data class Multiply(val operand1: Double) : CalculatorUiEvent()

    data class Divide(val operand1: Double) : CalculatorUiEvent()

    data class Result(val operand1: Double) : CalculatorUiEvent()

    object Clear : CalculatorUiEvent()
}
