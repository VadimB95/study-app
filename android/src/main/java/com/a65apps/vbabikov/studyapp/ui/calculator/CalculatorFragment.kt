package com.a65apps.vbabikov.studyapp.ui.calculator

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.a65apps.vbabikov.studyapp.common.ObservableSourceFragment
import com.a65apps.vbabikov.studyapp.databinding.FragmentCalculatorBinding
import com.a65apps.vbabikov.studyapp.navigation.BackButtonListener
import com.a65apps.vbabikov.studyapp.ui.calculator.event.CalculatorUiEvent
import com.a65apps.vbabikov.studyapp.ui.calculator.viewstate.CalculatorViewState
import com.a65apps.vbabikov.studyapp.utils.KeyboardUtils.showKeyboard
import dagger.hilt.android.AndroidEntryPoint
import io.reactivex.functions.Consumer
import javax.inject.Inject

@AndroidEntryPoint
class CalculatorFragment : ObservableSourceFragment<CalculatorUiEvent>(), BackButtonListener,
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

        with(binding) {
            toolbarCalc.setNavigationOnClickListener {
                viewModel.navigateBack()
            }
            buttonCalcAdd.setOnClickListener {
                onNext(CalculatorUiEvent.Add(getInputFromScreen()))
            }
            buttonCalcClear.setOnClickListener {
                onNext(CalculatorUiEvent.Clear)
            }
            buttonCalcResult.setOnClickListener {
                onNext(CalculatorUiEvent.Result(getInputFromScreen()))
            }
            edittextCalc.requestFocus()
            showKeyboard(edittextCalc)
        }
        calcBinding.setup(this)
    }

    private fun FragmentCalculatorBinding.getInputFromScreen() =
        edittextCalc.text.toString().toDouble()

    override fun onBackPressed() {
        viewModel.navigateBack()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun accept(viewState: CalculatorViewState?) {
        viewState?.let {
            binding.edittextCalc.setText(it.screenText)
        }
    }

    companion object {
        fun newInstance() = CalculatorFragment()
    }
}
