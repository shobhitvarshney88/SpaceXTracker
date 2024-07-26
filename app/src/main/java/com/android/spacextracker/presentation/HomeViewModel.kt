package com.android.spacextracker.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.spacextracker.Resource
import com.android.spacextracker.data.repository.HomeRepository
import com.android.spacextracker.domain.GetSpaceXResponse
import com.android.spacextracker.domain.SpaceXData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val homeRepository: HomeRepository):ViewModel() {

    var spaceXList: ArrayList<SpaceXData> = arrayListOf()

    private val _getSpaceXLaunchResponse = MutableLiveData<Resource<GetSpaceXResponse>>()
    val getSpaceXLaunchResponse: LiveData<Resource<GetSpaceXResponse>> = _getSpaceXLaunchResponse

    fun getRunningPlanApi() {
        _getSpaceXLaunchResponse.postValue(Resource.Loading(null))
            CoroutineScope(Dispatchers.IO).launch {
                val response = homeRepository.getSpaceXLaunchesApi()
                val result = response.body()
                if (response.isSuccessful && result != null) {
                    _getSpaceXLaunchResponse.postValue(Resource.Success(result))
                } else {
                    _getSpaceXLaunchResponse.postValue(Resource.Error(response.message()))
                }
            }

    }

}