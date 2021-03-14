package com.a65apps.vbabikov.studyapp.ui.calculator

import com.a65apps.vbabikov.studyapp.calculator.CalculatorFeature
import com.a65apps.vbabikov.studyapp.ui.calculator.viewstate.CalculatorViewStateTransformer
import com.badoo.binder.Binder
import com.badoo.binder.using
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject

@ViewModelScoped
class CalculatorBindings @Inject constructor(
    private val feature: CalculatorFeature,
    private val viewStateTransformer: CalculatorViewStateTransformer
) {
    private val binder: Binder = Binder()

    fun setup(viewModel: CalculatorViewModel) {
        binder.bind(viewModel to feature)
        binder.bind(feature to viewModel using viewStateTransformer)
    }

    fun unbind() {
        binder.dispose()
    }
}
