package com.android.spacextracker.data.api

import com.android.spacextracker.domain.GetSpaceXResponse
import retrofit2.Response
import retrofit2.http.GET

interface ApiInterface {

    @GET("launches")
   suspend fun getSpaceXLaunches(): Response<GetSpaceXResponse>

}