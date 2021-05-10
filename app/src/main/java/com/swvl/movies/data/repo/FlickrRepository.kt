package com.swvl.movies.data.repo

import android.util.Log
import com.swvl.movies.data.api.FlickrService
import com.swvl.movies.data.model.APIResponse
import com.swvl.movies.data.model.FlickrSearchResponse
import com.swvl.movies.data.model.Photo
import retrofit2.HttpException
import java.io.IOException

class FlickrRepository(private val service: FlickrService) : FlickrDataSource {

    override suspend fun getPhotosList(query: String): APIResponse<FlickrSearchResponse> {
        try {
            val searchedPhotos = service.searchPhotos(query)
            Log.d("GithubRepository", "response $searchedPhotos")
            return APIResponse.Success<FlickrSearchResponse>(searchedPhotos)
        }catch (exception: IOException) {
            return APIResponse.Failure("Something went wrong")
        } catch (exception: HttpException) {
            return APIResponse.Failure("Something went wrong")
        }

    }

}