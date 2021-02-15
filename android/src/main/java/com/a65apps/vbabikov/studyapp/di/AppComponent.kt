package com.a65apps.vbabikov.studyapp.di

import com.a65apps.vbabikov.studyapp.ui.MainActivity
import com.a65apps.vbabikov.studyapp.ui.calculator.CalculatorViewModel
import com.a65apps.vbabikov.studyapp.ui.home.HomeViewModel
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        NavigationModule::class
    ]
)
interface AppComponent {
    fun inject(activity: MainActivity)

    fun inject(viewModel: HomeViewModel)

    fun inject(viewModel: CalculatorViewModel)
}
