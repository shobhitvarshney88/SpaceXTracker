package com.android.spacextracker.ui.search

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.android.spacextracker.Resource
import com.android.spacextracker.databinding.FragmentSearchBinding
import com.android.spacextracker.domain.SpaceXData
import com.android.spacextracker.presentation.HomeViewModel
import com.android.spacextracker.ui.adapter.SpaceXAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SearchFragment : Fragment() {
    private var _binding: FragmentSearchBinding? = null
    private val binding get() = _binding!!
    private lateinit var spaceXAdapter: SpaceXAdapter
    private val homeViewModel by viewModels<HomeViewModel>()
    private val filteredSpaceXList = mutableListOf<SpaceXData>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSearchBinding.inflate(layoutInflater, container, false)
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
        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                filter(newText.toString())
                return false
            }

        })
    }

    private fun filter(text: String) {
        val filteredList: ArrayList<SpaceXData> = ArrayList()

        for (item in homeViewModel.spaceXList) {
            if (item.mission_name!!.contains(
                    text,
                    true
                ) || item.rocket?.rocket_name!!.contains(text, true) || item.launch_year!!.contains(
                    text,
                    true
                )
            ) {

                filteredList.add(item)
            }
        }
        if (filteredList.isEmpty()) {
            Toast.makeText(requireContext(), "No Data Found", Toast.LENGTH_SHORT).show()
        }
        spaceXAdapter.filterList(filteredList)

    }


    private fun onSpaceItemClick(model: SpaceXData, pos: Int) {
        val action = SearchFragmentDirections.actionSearchToRocketDetailFragment(model)
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