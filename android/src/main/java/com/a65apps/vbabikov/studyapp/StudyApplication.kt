package com.a65apps.vbabikov.studyapp

import android.app.Application
import com.a65apps.vbabikov.studyapp.di.DaggerAppComponent
import io.reactivex.Completable
import io.reactivex.schedulers.Schedulers
import timber.log.Timber

class StudyApplication : Application() {
    val appComponent = DaggerAppComponent.create()

    override fun onCreate() {
        super.onCreate()
        delayedInit()
    }

    private fun delayedInit() {
        INSTANCE = this

        Completable.fromRunnable {
            Timber.plant(Timber.DebugTree())
        }
            .subscribeOn(Schedulers.computation())
            .subscribe()
    }

    companion object {
        lateinit var INSTANCE: StudyApplication
    }
}