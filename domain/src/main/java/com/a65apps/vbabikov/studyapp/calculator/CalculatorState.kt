package com.a65apps.vbabikov.studyapp.calculator

import java.math.BigDecimal

data class CalculatorState(
    val operand1: BigDecimal = BigDecimal.ZERO,
    val pendingOperation: ArithmeticOperations? = null,
    val screenText: String = "0",
    val requireOverrideInput: Boolean = true
)
