package com.a65apps.vbabikov.studyapp

import com.badoo.mvicore.feature.BaseFeature
import javax.inject.Inject

class CalculatorFeature @Inject constructor() :
    BaseFeature<CalculatorWish, CalculatorAction, CalculatorEffect, CalculatorState, Nothing>(
        initialState = CalculatorState(),
        actor = CalculatorActor(),
        reducer = CalculatorReducer(),
        postProcessor = CalculatorPostProcessor(),
        wishToAction = ::wishToAction
    )

fun wishToAction(wish: CalculatorWish): CalculatorAction = when (wish) {
    is CalculatorWish.Input -> CalculatorAction.Input(
        screenTextInput = wish.screenTextInput,
        start = wish.start,
        count = wish.count
    )
    CalculatorWish.Add -> CalculatorAction.Add
    CalculatorWish.Subtract -> CalculatorAction.Subtract
    CalculatorWish.Multiply -> CalculatorAction.Multiply
    CalculatorWish.Divide -> CalculatorAction.Divide
    CalculatorWish.Result -> CalculatorAction.Result
    CalculatorWish.Clear -> CalculatorAction.Clear
}
