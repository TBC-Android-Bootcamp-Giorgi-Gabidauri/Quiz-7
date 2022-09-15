package com.gabo.quiz7.ui

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.gabo.quiz7.adapter.ActiveCoursesAdapter
import com.gabo.quiz7.adapter.NewCoursesAdapter
import com.gabo.quiz7.databinding.ActivityMainBinding
import com.gabo.quiz7.extensions.launchStarted
import com.gabo.quiz7.extensions.toModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var activeCoursesAdapter: ActiveCoursesAdapter
    private lateinit var newCoursesAdapter: NewCoursesAdapter
    private val viewModel: MainVM by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupAdapters()
        setupObservers()
    }

    private fun setupObservers() {
        launchStarted {
            viewModel.defaultState.collect {
                if (it.errorMsg.isNotEmpty()) {
                    Toast.makeText(this, it.errorMsg, Toast.LENGTH_SHORT).show()
                }
//                activeCoursesAdapter.submitList(it.data?.activeCourses?.map { it.toModel() }
//                    ?: emptyList())
//                newCoursesAdapter.submitList(it.data?.newCourses?.map { it.toModel() }
//                    ?: emptyList())
            }
        }
        launchStarted {
            viewModel.state.collect{
                activeCoursesAdapter.submitList(it.activeCourses)
                newCoursesAdapter.submitList(it.newCourses)
            }
        }
    }

    private fun setupAdapters() {
        with(binding) {
            activeCoursesAdapter = ActiveCoursesAdapter()
            rvActiveCourses.adapter = activeCoursesAdapter
            rvActiveCourses.layoutManager = LinearLayoutManager(this@MainActivity)

            newCoursesAdapter = NewCoursesAdapter()
            rvNewCourses.adapter = newCoursesAdapter
            rvNewCourses.layoutManager =
                LinearLayoutManager(this@MainActivity, LinearLayoutManager.HORIZONTAL, false)
        }
    }
}