package com.swvl.movies

import com.swvl.movies.data.model.APIResponse
import com.swvl.movies.data.model.FlickrSearchResponse
import com.swvl.movies.data.repo.FlickrDataSource

class MockFlickrRepository : FlickrDataSource {


    override suspend fun getPhotosList(query: String): APIResponse<FlickrSearchResponse> {
        val mockResponse = FlickrSearchResponse(null,null)
        return APIResponse.Success<FlickrSearchResponse>(mockResponse)
    }
}