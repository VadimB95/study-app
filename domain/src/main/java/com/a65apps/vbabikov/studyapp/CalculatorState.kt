package com.a65apps.vbabikov.studyapp

data class CalculatorState(
    val operand1: Double = 0.0,
    val pendingOperation: ArithmeticOperations? = null,
    val screenText: String = "0",
    val requireOverrideInput: Boolean = true
)
