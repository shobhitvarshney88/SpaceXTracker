package com.android.spacextracker.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.android.spacextracker.databinding.LaunchesItemBinding
import com.android.spacextracker.domain.SpaceXData

class SpaceXAdapter(private val onSpaceItemClick: (SpaceXData, Int) -> Unit) :
    ListAdapter<SpaceXData, SpaceXAdapter.SpaceXViewHolder>(SpaceXCallback()) {
    private var filteredFullList: List<SpaceXData> = listOf()

    inner class SpaceXViewHolder(private val binding: LaunchesItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: SpaceXData) = with(binding) {
            tvMissionName.text = item.mission_name
            tvRocketName.text = item.rocket?.rocket_name
            tvMissionYear.text = item.launch_year
            itemView.setOnClickListener {
                onSpaceItemClick.invoke(item, adapterPosition)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SpaceXViewHolder {
        val binding =
            LaunchesItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SpaceXViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SpaceXViewHolder, position: Int) {
        return holder.bind(getItem(position))
    }

    override fun submitList(list: List<SpaceXData>?) {
        super.submitList(list)
        if (list != null) {
            filteredFullList = list
        }
    }

    fun filterList(filterlist: ArrayList<SpaceXData>) {
        filteredFullList = filterlist
        submitList(filteredFullList)
    }
}

class SpaceXCallback : DiffUtil.ItemCallback<SpaceXData>() {
    override fun areItemsTheSame(
        oldItem: SpaceXData,
        newItem: SpaceXData
    ): Boolean {
        return oldItem.mission_id == newItem.mission_id
    }

    override fun areContentsTheSame(
        oldItem: SpaceXData,
        newItem: SpaceXData
    ): Boolean {
        return oldItem == newItem
    }


}