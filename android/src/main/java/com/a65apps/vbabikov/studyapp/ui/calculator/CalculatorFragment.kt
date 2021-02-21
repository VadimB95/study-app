package com.a65apps.vbabikov.studyapp.ui.calculator

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.a65apps.vbabikov.studyapp.databinding.FragmentCalculatorBinding
import com.a65apps.vbabikov.studyapp.navigation.BackButtonListener
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CalculatorFragment : Fragment(), BackButtonListener {
    private val viewModel: CalculatorViewModel by viewModels()

    private var _binding: FragmentCalculatorBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCalculatorBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.toolbarCalc.setNavigationOnClickListener {
            viewModel.navigateBack()
        }
    }

    override fun onBackPressed() {
        viewModel.navigateBack()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
