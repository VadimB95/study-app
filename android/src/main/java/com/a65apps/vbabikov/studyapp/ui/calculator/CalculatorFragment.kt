package com.a65apps.vbabikov.studyapp.ui.calculator

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.a65apps.vbabikov.studyapp.CalculatorWish
import com.a65apps.vbabikov.studyapp.common.ObservableSourceFragment
import com.a65apps.vbabikov.studyapp.databinding.FragmentCalculatorBinding
import com.a65apps.vbabikov.studyapp.navigation.BackButtonListener
import com.a65apps.vbabikov.studyapp.ui.calculator.viewstate.CalculatorViewState
import com.a65apps.vbabikov.studyapp.utils.KeyboardUtils.showKeyboard
import dagger.hilt.android.AndroidEntryPoint
import io.reactivex.functions.Consumer
import timber.log.Timber
import javax.inject.Inject

@AndroidEntryPoint
class CalculatorFragment : ObservableSourceFragment<CalculatorWish>(), BackButtonListener,
    Consumer<CalculatorViewState> {
    private val viewModel: CalculatorViewModel by viewModels()

    private var _binding: FragmentCalculatorBinding? = null
    private val binding
        get() = requireNotNull(_binding) {
            "Cannot be called before onCreateView() and after onDestroyView()"
        }

    @Inject
    lateinit var calcBinding: CalculatorBindings

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCalculatorBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViews()
        calcBinding.setup(this)

    }

    private fun initViews() {
        with(binding) {
            toolbarCalc.setNavigationOnClickListener {
                viewModel.navigateBack()
            }
            buttonCalcAdd.setOnClickListener {
                onNext(CalculatorWish.Add)
            }
            buttonCalcSub.setOnClickListener {
                onNext(CalculatorWish.Subtract)
            }
            buttonCalcMult.setOnClickListener {
                onNext(CalculatorWish.Multiply)
            }
            buttonCalcDiv.setOnClickListener {
                onNext(CalculatorWish.Divide)
            }
            buttonCalcResult.setOnClickListener {
                onNext(CalculatorWish.Result)
            }
            buttonCalcClear.setOnClickListener {
                onNext(CalculatorWish.Clear)
            }

            edittextCalc.addTextChangedListener(object : TextWatcher {
                private var start = 0
                private var count = 0
                private var isClear = true

                init {
                    Timber.d("TextWatcher init()")
                }

                override fun beforeTextChanged(
                    s: CharSequence?,
                    start: Int,
                    count: Int,
                    after: Int
                ) {
                    // Not used
                }

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                    this.start = start
                    this.count = count
                }

                override fun afterTextChanged(s: Editable?) {

                    onNext(
                        CalculatorWish.Input(
                            screenTextInput = s.toString(),
                            start = start,
                            count = count
                        )
                    )
                }
            }
            )
            // todo не скрывается клавиатура
            // todo придумать как корректно работать с clear
            edittextCalc.requestFocus()
            showKeyboard(edittextCalc)
        }
    }

    override fun onBackPressed() {
        viewModel.navigateBack()
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }

    override fun onDestroy() {
        calcBinding.binder.dispose()
        super.onDestroy()
    }

    override fun accept(viewState: CalculatorViewState?) {
        viewState?.let {
            val edittextCalc = binding.edittextCalc
            if (it.screenText != edittextCalc.text.toString())
                edittextCalc.setText(it.screenText)
            edittextCalc.setSelection(edittextCalc.text?.length ?: 0)
        }
    }

    companion object {
        fun newInstance() = CalculatorFragment()
    }
}
