package com.example.fastingtracker.learn

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.fastingtracker.R
import com.example.fastingtracker.databinding.FragmentLearnOverviewBinding

class LearnOverviewFragment : Fragment() {
    // TODO: Implement Fragment

    private var _binding: FragmentLearnOverviewBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLearnOverviewBinding.inflate(inflater, container, false)
        activity?.setTitle(R.string.bottom_nav_learn)

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}