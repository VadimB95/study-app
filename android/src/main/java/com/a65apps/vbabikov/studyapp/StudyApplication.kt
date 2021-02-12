package com.a65apps.vbabikov.studyapp

import android.app.Application
import com.a65apps.vbabikov.studyapp.di.DaggerAppComponent
import timber.log.Timber

class StudyApplication : Application() {
    val appComponent = DaggerAppComponent.create()

    override fun onCreate() {
        super.onCreate()
        delayedInit()
    }

    // TODO make async
    private fun delayedInit() {
        INSTANCE = this
        Timber.plant(Timber.DebugTree())
    }

    companion object {
        lateinit var INSTANCE: StudyApplication
    }
}