package com.a65apps.vbabikov.studyapp.calculator

sealed class CalculatorWish {

    data class Input(
        val screenTextInput: String,
        val start: Int,
        val count: Int
    ) : CalculatorWish()

    object Add : CalculatorWish()

    object Subtract : CalculatorWish()

    object Multiply : CalculatorWish()

    object Divide : CalculatorWish()

    object Result : CalculatorWish()

    object Clear : CalculatorWish()
}
