package com.a65apps.vbabikov.studyapp.di

import com.a65apps.vbabikov.studyapp.MainActivity
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
}
