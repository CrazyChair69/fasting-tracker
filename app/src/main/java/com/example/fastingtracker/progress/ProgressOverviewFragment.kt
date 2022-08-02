package com.example.fastingtracker.progress

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fastingtracker.FastingTrackerApplication
import com.example.fastingtracker.R
import com.example.fastingtracker.databinding.FragmentProgressOverviewBinding
import com.example.fastingtracker.progress.viewmodel.ProgressViewModel
import com.example.fastingtracker.progress.viewmodel.ProgressViewModelFactory

class ProgressOverviewFragment : Fragment() {
    // TODO: Implement RecyclerView
    // TODO: Implement Spinner that uses database

    private val viewModel: ProgressViewModel by activityViewModels {
        ProgressViewModelFactory(
            (activity?.application as FastingTrackerApplication).database.dietDao()
        )
    }

    private var _binding: FragmentProgressOverviewBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProgressOverviewBinding.inflate(inflater, container, false)
        activity?.setTitle(R.string.bottom_nav_progress)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.progressOverviewRvEntryValues.layoutManager = LinearLayoutManager(this.context)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}