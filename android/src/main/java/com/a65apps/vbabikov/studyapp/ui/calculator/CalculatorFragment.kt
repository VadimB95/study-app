package com.a65apps.vbabikov.studyapp.ui.calculator

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.a65apps.vbabikov.studyapp.calculator.CalculatorState
import com.a65apps.vbabikov.studyapp.databinding.FragmentCalculatorBinding
import com.a65apps.vbabikov.studyapp.navigation.BackButtonListener
import com.a65apps.vbabikov.studyapp.utils.KeyboardUtils
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CalculatorFragment : Fragment(), BackButtonListener {

    private val viewModel: CalculatorViewModel by viewModels()

    private var _binding: FragmentCalculatorBinding? = null
    private val binding
        get() = requireNotNull(_binding) {
            "Cannot be called before onCreateView() and after onDestroyView()"
        }

    private var calculatorTextWatcher: CalculatorTextWatcher? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCalculatorBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViews()
        viewModel.viewState.observe(viewLifecycleOwner, ::handleState)
        KeyboardUtils.showKeyboard(binding.editTextCalc)
    }

    private fun setupViews() {
        with(binding) {
            toolbarCalc.setNavigationOnClickListener {
                viewModel.navigateBack()
            }
            buttonCalcAdd.setOnClickListener {
                viewModel.add()
            }
            buttonCalcSub.setOnClickListener {
                viewModel.subtract()
            }
            buttonCalcMult.setOnClickListener {
                viewModel.multiply()
            }
            buttonCalcDiv.setOnClickListener {
                viewModel.divide()
            }
            buttonCalcResult.setOnClickListener {
                viewModel.result()
            }
            buttonCalcClear.setOnClickListener {
                viewModel.clear()
            }
            calculatorTextWatcher = CalculatorTextWatcher(viewModel)
            editTextCalc.addTextChangedListener(calculatorTextWatcher)
        }
    }

    override fun onBackPressed() {
        viewModel.navigateBack()
    }

    override fun onStop() {
        KeyboardUtils.hideKeyboard(binding.editTextCalc)
        super.onStop()
    }

    override fun onDestroyView() {
        binding.editTextCalc.removeTextChangedListener(calculatorTextWatcher)
        _binding = null
        calculatorTextWatcher = null
        super.onDestroyView()
    }

    private fun handleState(state: CalculatorState) {
        with(binding) {
            if (state.screenText != editTextCalc.text.toString()) {
                editTextCalc.setText(state.screenText)
            }
            editTextCalc.setSelection(editTextCalc.text?.length ?: 0)
        }
    }

    companion object {
        fun newInstance() = CalculatorFragment()
    }
}

private class CalculatorTextWatcher(
    private val viewModel: CalculatorViewModel
) : TextWatcher {
    private var start = 0
    private var count = 0

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
        viewModel.input(
            screenTextInput = s.toString(),
            start = start,
            count = count
        )
    }
}
