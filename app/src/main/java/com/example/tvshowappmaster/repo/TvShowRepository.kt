package com.example.tvshowappmaster.repo

import com.example.tvshowappmaster.api.ApiService
import javax.inject.Inject

class TvShowRepository @Inject constructor(
    private var apiService: ApiService
) {

    suspend fun getTvShow() = apiService.getTvShows()
    suspend fun getPeople() = apiService.getPeople()
}