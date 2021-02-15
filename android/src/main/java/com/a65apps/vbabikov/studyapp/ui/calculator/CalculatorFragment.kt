package com.a65apps.vbabikov.studyapp.ui.calculator

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.a65apps.vbabikov.studyapp.StudyApplication
import com.a65apps.vbabikov.studyapp.databinding.FragmentCalculatorBinding
import com.a65apps.vbabikov.studyapp.navigation.BackButtonListener

class CalculatorFragment : Fragment(), BackButtonListener {
    private val viewModel: CalculatorViewModel by viewModels()

    private lateinit var binding: FragmentCalculatorBinding

    override fun onAttach(context: Context) {
        super.onAttach(context)
        StudyApplication.INSTANCE.appComponent.inject(viewModel)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCalculatorBinding.inflate(inflater)
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
}
