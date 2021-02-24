package com.a65apps.vbabikov.studyapp

import com.badoo.mvicore.feature.ReducerFeature
import javax.inject.Inject

class CalculatorFeature @Inject constructor() :
    ReducerFeature<CalculatorWish, CalculatorState, Nothing>(
        initialState = CalculatorState(),
        reducer = CalculatorReducer()
    )
