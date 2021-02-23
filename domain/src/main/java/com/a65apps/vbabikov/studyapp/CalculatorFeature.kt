package com.a65apps.vbabikov.studyapp

import com.badoo.mvicore.feature.ReducerFeature

class CalculatorFeature : ReducerFeature<CalculatorWish, CalculatorState, Nothing>(
    initialState = CalculatorState(),
    reducer = CalculatorReducer()
)
