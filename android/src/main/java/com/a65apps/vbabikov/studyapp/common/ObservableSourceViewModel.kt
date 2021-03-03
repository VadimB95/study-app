package com.a65apps.vbabikov.studyapp.common

import androidx.lifecycle.ViewModel
import io.reactivex.ObservableSource
import io.reactivex.Observer
import io.reactivex.subjects.PublishSubject

abstract class ObservableSourceViewModel<T> : ViewModel(), ObservableSource<T> {

    private val source = PublishSubject.create<T>()

    protected fun onNext(t: T) {
        source.onNext(
            requireNotNull(t) { "Nullable UI-event cannot be sent" }
        )
    }

    override fun subscribe(observer: Observer<in T>) {
        source.subscribe(observer)
    }
}