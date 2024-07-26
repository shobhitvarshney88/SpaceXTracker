package com.android.spacextracker.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.android.spacextracker.databinding.FragmentRocketDetailBinding
import com.android.spacextracker.domain.SpaceXData
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RocketDetailFragment : Fragment() {
    private var _binding: FragmentRocketDetailBinding? = null
    private val binding get() = _binding!!
    private lateinit var rocketData: SpaceXData
    private val args: RocketDetailFragmentArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        rocketData = args.rocketData
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRocketDetailBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setData()
        binding.ivBack.setOnClickListener {
            findNavController().popBackStack()
        }

    }

    private fun setData() = binding.run {
        tvMissionNameAns.text = rocketData.mission_name
        if (rocketData.launch_date_local != null) {
            tvLaunchDateAns.text = rocketData.launch_date_local?.substring(0, 10)
        }
        tvRocketTypeAns.text = rocketData.rocket?.rocket_type
        tvRocketNameAns.text = rocketData.rocket?.rocket_name
        tvNationalityAns.text =
            rocketData.rocket?.second_stage?.payloads?.get(0)?.nationality ?: "NA"
        tvManufacturerAns.text =
            rocketData.rocket?.second_stage?.payloads?.get(0)?.manufacturer ?: "NA"
        tvLaunchSiteAns.text = rocketData.launch_site?.site_name ?: "NA"
        tvPayloadMassKgAns.text =
            rocketData.rocket?.second_stage?.payloads?.get(0)?.payload_mass_kg.toString()
        tvPayloadMassLbsAns.text =
            rocketData.rocket?.second_stage?.payloads?.get(0)?.payload_mass_lbs.toString()
        tvPayloadTypeAns.text =
            rocketData.rocket?.second_stage?.payloads?.get(0)?.payload_type ?: "NA"
        tvReusedAns.text = rocketData.rocket?.second_stage?.payloads?.get(0)?.reused.toString()
        tvUidAns.text = rocketData.rocket?.second_stage?.payloads?.get(0)?.uid ?: "NA"
    }
}