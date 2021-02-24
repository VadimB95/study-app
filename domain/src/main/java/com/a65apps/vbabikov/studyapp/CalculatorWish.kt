package com.a65apps.vbabikov.studyapp

sealed class CalculatorWish {

    data class Add(val operand1: Double) : CalculatorWish()

    data class Subtract(val operand1: Double) : CalculatorWish()

    data class Multiply(val operand1: Double) : CalculatorWish()

    data class Divide(val operand1: Double) : CalculatorWish()

    data class Result(val operand2: Double) : CalculatorWish()

    object Clear : CalculatorWish()


}
