package com.swvl.movies.list

import com.swvl.movies.data.model.Movie
import com.swvl.movies.ui.list.MovieListViewModel
import org.junit.Assert
import org.junit.Test

class MovieListViewModelTest {

    private var reposRepository = MockRepo()


    @Test
    fun emptyListTest() {
        val movieListViewModel = MovieListViewModel(reposRepository)
        Assert.assertNull("Error is not null on start", movieListViewModel.errorMessage)
        movieListViewModel.fetchMovies()
        Thread.sleep(2000)
        movieListViewModel.errorMessage
        Assert.assertEquals("Movies not available", movieListViewModel.errorMessage)
    }

    @Test
    fun filledListTest() {
        val movies = ArrayList<Movie>()
        movies.add(Movie(emptyList(), emptyList(), 5, "test movie", 2000))
        reposRepository.listOfMovies = movies;
        val movieListViewModel = MovieListViewModel(reposRepository)
        Assert.assertNull("Error is not null on start", movieListViewModel.errorMessage)
        movieListViewModel.fetchMovies()
        Thread.sleep(2000)
        Assert.assertNotEquals(0, movieListViewModel.adapter.itemCount)
        Assert.assertEquals(null, movieListViewModel.errorMessage)
    }
}