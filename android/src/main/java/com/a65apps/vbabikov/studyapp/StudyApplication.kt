package com.a65apps.vbabikov.studyapp

import android.app.Application
import com.a65apps.vbabikov.studyapp.di.DaggerAppComponent

class StudyApplication : Application() {
    val appComponent = DaggerAppComponent.create()

    private fun delayedInit() {
    }

    companion object {
        lateinit var INSTANCE: StudyApplication
    }
}