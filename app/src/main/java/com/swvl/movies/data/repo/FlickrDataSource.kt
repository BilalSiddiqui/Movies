package com.swvl.movies.data.repo

import com.swvl.movies.data.model.APIResponse
import com.swvl.movies.data.model.FlickrSearchResponse
import com.swvl.movies.data.model.Photo

interface FlickrDataSource {
    suspend fun getPhotosList(query: String): APIResponse<FlickrSearchResponse>
}