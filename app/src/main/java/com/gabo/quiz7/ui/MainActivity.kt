package com.gabo.quiz7.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.gabo.quiz7.adapter.ActiveCoursesAdapter
import com.gabo.quiz7.adapter.NewCoursesAdapter
import com.gabo.quiz7.databinding.ActivityMainBinding
import com.gabo.quiz7.domain.models.ActiveCoursesModel
import com.gabo.quiz7.domain.models.NewCoursesModel
import com.gabo.quiz7.extensions.launchStarted
import com.gabo.quiz7.other.ResponseHandler
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

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
        with(viewModel) {
            launchStarted {
                getActiveCourses().collect {
                    when (it) {
                        is ResponseHandler.Success -> {
                            val list = it.data
                            val largerList = mutableListOf<ActiveCoursesModel>()
                            repeat(4) {
                                list?.forEach { model -> largerList.add(model) }
                            }
                            activeCoursesAdapter.submitList(largerList)
                        }
                        else -> {
                        }
                    }
                }
            }
            launchStarted {
                getNewCourses().collect {
                    when (it) {
                        is ResponseHandler.Success -> {
                            val list = it.data
                            val largerList = mutableListOf<NewCoursesModel>()
                            repeat(4) {
                                list?.forEach { largerList.add(it) }
                            }
                            newCoursesAdapter.submitList(largerList)
                        }
                        else -> {
                        }
                    }
                }
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