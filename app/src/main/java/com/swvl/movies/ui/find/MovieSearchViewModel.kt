package com.swvl.movies.ui.find

import androidx.appcompat.widget.SearchView
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.swvl.movies.R
import com.swvl.movies.data.model.Movie
import com.swvl.movies.data.model.MovieListResponse
import com.swvl.movies.data.repo.MovieDataSource
import com.swvl.movies.utils.MovieApplication
import kotlinx.coroutines.*

class MovieSearchViewModel(private val repository: MovieDataSource) : ViewModel() {
    //For debouncing search
    var queryTextChangedJob: Job? = null
    val DEBOUNCING_TIME:Long=500

    val adapter = MovieSearchAdapter()
    var errorMessageLiveData= MutableLiveData<String>()


    val queryTextListener = object : SearchView.OnQueryTextListener {
        override fun onQueryTextChange(newText: String): Boolean {
            fetchMovies(newText);
            return true
        }

        override fun onQueryTextSubmit(newQuery: String): Boolean {
            return false
        }
    }

    fun fetchMovies(query: String) {
        if (query.isNotEmpty()) {
            queryTextChangedJob?.cancel()
            queryTextChangedJob =  viewModelScope.launch(Dispatchers.IO) {
                delay(DEBOUNCING_TIME)
                val moviesListResponse = repository.getMoviesList(MovieApplication.instance)
                withContext(Dispatchers.Main) {
                    updateViewWithList(moviesListResponse, query)
                }
            }
        } else {
            showEmptyList()
        }
    }

    private fun showEmptyList() {
        adapter.submitList(emptyList())
    }

    private fun showNotFoundView() {
        errorMessageLiveData.postValue( MovieApplication.instance.resources.getString(R.string.not_found_in_search))
        adapter.submitList(emptyList())
    }
    private fun showNotRecordView() {
        errorMessageLiveData.postValue(MovieApplication.instance.resources.getString(R.string.no_record))
        adapter.submitList(emptyList())
    }


    private fun updateViewWithList(
        moviesListResponse: MovieListResponse,
        query: String
    ) {

        if (moviesListResponse.movies.isNullOrEmpty()) {
            showNotRecordView()
        } else {
            val filteredList = getFilteredList(moviesListResponse, query)
            if (filteredList.isNotEmpty()) {
                adapter.submitList(getPresentableList(filteredList))
                errorMessageLiveData.postValue(null)
            } else {
                showNotFoundView()
            }
        }

    }

    fun getFilteredList(
        moviesListResponse: MovieListResponse,
        query: String
    ) = moviesListResponse.movies.filter { it.title.contains(query) }



     fun getPresentableList(movies: List<Movie>): List<RecyclerItem> {
        val presentalbeList = ArrayList<RecyclerItem>();
        val groupedMovies = movies.groupBy { it.year }
        val keyset = groupedMovies.keys.sortedDescending()
        for (year in keyset) {
            if (groupedMovies[year]?.isNotEmpty()!!) {
                presentalbeList.add(RecyclerItem.Section(year.toString()))
                val toIndex = if (groupedMovies[year]?.size!! > 5) 5 else groupedMovies[year]!!.size
                presentalbeList.addAll(groupedMovies[year]!!.sortedByDescending { it.rating }
                    .subList(0, toIndex).map { RecyclerItem.Movie(it.title,it.rating) })
            }
        }
        return presentalbeList
    }
}