package com.a65apps.vbabikov.studyapp.ui.home

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.a65apps.vbabikov.studyapp.StudyApplication
import com.a65apps.vbabikov.studyapp.databinding.FragmentHomeBinding
import com.a65apps.vbabikov.studyapp.navigation.BackButtonListener

class HomeFragment : Fragment(), BackButtonListener {
    private val viewModel: HomeViewModel by viewModels()

    private lateinit var binding: FragmentHomeBinding

    override fun onAttach(context: Context) {
        super.onAttach(context)
        StudyApplication.INSTANCE.appComponent.inject(viewModel)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonHomeCalc.setOnClickListener {
            viewModel.navigateToCalculator()
        }
    }

    override fun onBackPressed() {
        viewModel.navigateBack()
    }
}