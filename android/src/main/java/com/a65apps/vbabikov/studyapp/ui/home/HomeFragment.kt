package com.a65apps.vbabikov.studyapp.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.a65apps.vbabikov.studyapp.databinding.FragmentHomeBinding
import com.a65apps.vbabikov.studyapp.navigation.BackButtonListener
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment(), BackButtonListener {
    private val viewModel: HomeViewModel by viewModels()

    private var _binding: FragmentHomeBinding? = null
    private val binding
        get() = requireNotNull(_binding) {
            "Cannot be called before onCreateView() and after onDestroyView()"
        }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater)
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

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }

    companion object {
        fun newInstance() = HomeFragment()
    }
}
