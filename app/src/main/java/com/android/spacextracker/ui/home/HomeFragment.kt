package com.android.spacextracker.ui.home

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.hilt.navigation.fragment.hiltNavGraphViewModels
import androidx.navigation.fragment.findNavController
import com.android.spacextracker.R
import com.android.spacextracker.Resource
import com.android.spacextracker.databinding.FragmentHomeBinding
import com.android.spacextracker.domain.SpaceXData
import com.android.spacextracker.presentation.HomeViewModel
import com.android.spacextracker.ui.adapter.SpaceXAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private lateinit var spaceXAdapter: SpaceXAdapter
    private val homeViewModel by hiltNavGraphViewModels<HomeViewModel>(R.id.home_nav_graph)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        spaceXAdapter = SpaceXAdapter { model, pos ->
            onSpaceItemClick(model, pos)
        }
        binding.rvSpaceX.adapter = spaceXAdapter
        homeViewModel.getRunningPlanApi()
        getSpaceXRocketObserver()
    }

    private fun onSpaceItemClick(model: SpaceXData, pos: Int) {

        val action = HomeFragmentDirections.actionHomeToRocketDetailFragment(model)
        findNavController().navigate(action)
    }

    private fun getSpaceXRocketObserver() {
        homeViewModel.getSpaceXLaunchResponse.observe(viewLifecycleOwner) {
            when (it) {
                is Resource.Loading -> {
                }

                is Resource.Success -> {
                    homeViewModel.spaceXList.addAll(
                        it.data!!
                    )
                    spaceXAdapter.submitList(homeViewModel.spaceXList)
                    Log.d("Home", "Success")
                }

                is Resource.Error -> {
                }
            }
        }
    }

}