package com.example.fastingtracker.progress

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.fastingtracker.R
import com.example.fastingtracker.databinding.FragmentProgressOverviewBinding

class ProgressOverviewFragment : Fragment() {
    // TODO: Implement Fragment

    private var _binding: FragmentProgressOverviewBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProgressOverviewBinding.inflate(inflater, container, false)

        // Set title of fragment
        activity?.setTitle(R.string.bottom_nav_progress)

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}