package com.a65apps.vbabikov.studyapp.ui.calculator

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.a65apps.vbabikov.studyapp.calculator.CalculatorWish
import com.a65apps.vbabikov.studyapp.common.ObservableSourceViewModel
import com.a65apps.vbabikov.studyapp.ui.calculator.viewstate.CalculatorViewState
import com.github.terrakok.cicerone.Router
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.functions.Consumer
import javax.inject.Inject

@HiltViewModel
class CalculatorViewModel @Inject constructor(
    private val router: Router,
    private val calcBinding: CalculatorBindings
) : ObservableSourceViewModel<CalculatorWish>(), Consumer<CalculatorViewState> {

    private val mutableState = MutableLiveData<CalculatorViewState>()
    val viewState: LiveData<CalculatorViewState>
        get() = mutableState

    init {
        calcBinding.setup(this)
    }

    override fun accept(viewState: CalculatorViewState?) {
        viewState?.let {
            mutableState.postValue(it)
        }
    }

    fun add() = onNext(CalculatorWish.Add)

    fun subtract() = onNext(CalculatorWish.Subtract)

    fun multiply() = onNext(CalculatorWish.Multiply)

    fun divide() = onNext(CalculatorWish.Divide)

    fun result() = onNext(CalculatorWish.Result)

    fun clear() = onNext(CalculatorWish.Clear)

    fun input(
        screenTextInput: String,
        start: Int,
        count: Int
    ) {
        onNext(
            CalculatorWish.Input(
                screenTextInput = screenTextInput,
                start = start,
                count = count
            )
        )
    }

    fun navigateBack() = router.exit()

    override fun onCleared() {
        calcBinding.binder.dispose()
        super.onCleared()
    }
}
