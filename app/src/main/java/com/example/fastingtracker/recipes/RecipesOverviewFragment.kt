package com.example.fastingtracker.recipes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.fastingtracker.R
import com.example.fastingtracker.databinding.FragmentRecipesOverviewBinding

class RecipesOverviewFragment : Fragment() {
    // TODO: Implement Fragment

    private var _binding: FragmentRecipesOverviewBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRecipesOverviewBinding.inflate(inflater, container, false)

        // Set title of fragment
        activity?.setTitle(R.string.bottom_nav_recipes)

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}