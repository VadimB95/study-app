package com.a65apps.vbabikov.studyapp

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import io.reactivex.Completable
import io.reactivex.schedulers.Schedulers
import timber.log.Timber

@HiltAndroidApp
class StudyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        delayedInit()
    }

    private fun delayedInit() {
        Completable.fromRunnable {
            Timber.plant(Timber.DebugTree())
        }
            .subscribeOn(Schedulers.computation())
            .subscribe()
    }
}
