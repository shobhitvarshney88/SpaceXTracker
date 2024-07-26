package com.android.spacextracker.data.repository

import com.android.spacextracker.data.api.ApiInterface
import com.android.spacextracker.domain.GetSpaceXResponse
import retrofit2.Call
import retrofit2.Response
import javax.inject.Inject

class HomeRepository @Inject constructor(private val apiInterface: ApiInterface) {

    suspend fun getSpaceXLaunchesApi(): Response<GetSpaceXResponse> =
        apiInterface.getSpaceXLaunches()
}