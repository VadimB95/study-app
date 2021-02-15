package com.a65apps.vbabikov.studyapp.di

import com.a65apps.vbabikov.studyapp.ui.HomeFragment
import com.a65apps.vbabikov.studyapp.ui.MainActivity
import com.a65apps.vbabikov.studyapp.viewmodels.HomeViewModel
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

    fun inject(fragment: HomeFragment)

    fun inject(viewModel: HomeViewModel)
}
