package com.example.fastingtracker

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.example.fastingtracker.databinding.ActivityMainBinding
import com.example.fastingtracker.learn.LearnOverviewFragment
import com.example.fastingtracker.progress.ProgressOverviewFragment
import com.example.fastingtracker.recipes.RecipesOverviewFragment
import com.google.android.material.navigation.NavigationBarView

class MainActivity : AppCompatActivity() {

    // TODO: Add Fade-through animation when switching fragments

    private lateinit var binding: ActivityMainBinding

    private val onNavigationItemSelected = NavigationBarView.OnItemSelectedListener { item ->
        when (item.itemId) {
            // Respond to navigation item "progress" click
            R.id.bottom_nav_progress -> {
                replaceFragment(ProgressOverviewFragment())
                return@OnItemSelectedListener true
            }
            // Respond to navigation item "recipes" click
            R.id.bottom_nav_recipes -> {
                replaceFragment(RecipesOverviewFragment())
                return@OnItemSelectedListener true
            }
            // Respond to navigation item "learn" click
            R.id.bottom_nav_learn -> {
                replaceFragment(LearnOverviewFragment())
                return@OnItemSelectedListener true
            }
            else -> {
                false
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.bottomNav.setOnItemSelectedListener(onNavigationItemSelected)

        // Change color of navigation bar. Only available if API +21 (Lollipop)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.navigationBarColor = ContextCompat.getColor(this, R.color.blue_grey_dark)
        }
    }

    /**
     * Switches fragments out when user clicks on an icon in bottom navigation bar.
     *
     * @param fragment Fragment of selected icon in bottom navigation bar.
     */
    private fun replaceFragment(fragment: Fragment) {
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.nav_host_fragment, fragment)
        fragmentTransaction.commit()
    }
}