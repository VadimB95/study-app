package com.a65apps.vbabikov.studyapp.ui.calculator

import com.a65apps.vbabikov.studyapp.CalculatorFeature
import com.a65apps.vbabikov.studyapp.ui.calculator.viewstate.CalculatorViewStateTransformer
import com.badoo.binder.Binder
import com.badoo.binder.using
import dagger.hilt.android.scopes.FragmentScoped
import javax.inject.Inject

@FragmentScoped
class CalculatorBindings @Inject constructor(
    private val feature: CalculatorFeature,
    private val viewStateTransformer: CalculatorViewStateTransformer
) {
    val binder: Binder = Binder()

    fun setup(fragment: CalculatorFragment) {
        binder.bind(fragment to feature)
        binder.bind(feature to fragment using viewStateTransformer)
    }
}
