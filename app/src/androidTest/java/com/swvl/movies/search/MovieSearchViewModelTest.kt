package com.swvl.movies.search

import com.swvl.movies.MockMovieRepository
import com.swvl.movies.data.model.Movie
import com.swvl.movies.data.model.MovieListResponse
import com.swvl.movies.ui.find.MovieSearchViewModel
import org.junit.Assert
import org.junit.Test

class MovieSearchViewModelTest {

    private var reposRepository = MockMovieRepository()


    @Test
    fun notFoundMoviesListTest() {
        val movieSearchViewModel = MovieSearchViewModel(reposRepository)
        Assert.assertNull("Error is not null on start", movieSearchViewModel.errorMessageLiveData.value)
        val movies = ArrayList<Movie>()
        movies.add(Movie(emptyList(), emptyList(), 5, "test movie1", 2000))
        movies.add(Movie(emptyList(), emptyList(), 5, "test movie2", 2000))
        movies.add(Movie(emptyList(), emptyList(), 5, "test movie3", 2000))
        reposRepository.listOfMovies = movies;
        movieSearchViewModel.fetchMovies("test movie4")
        Thread.sleep(2000)
        Assert.assertEquals("No record found in search", movieSearchViewModel.errorMessageLiveData.value)
        Assert.assertEquals("List should be empty",0, movieSearchViewModel.adapter.itemCount)
    }

    @Test
    fun successfullyFoundMoviesListTest() {
        val movieSearchViewModel = MovieSearchViewModel(reposRepository)
        Assert.assertNull("Error is not null on start", movieSearchViewModel.errorMessageLiveData.value)
        val movies = ArrayList<Movie>()
        movies.add(Movie(emptyList(), emptyList(), 5, "test movie1", 2000))
        movies.add(Movie(emptyList(), emptyList(), 5, "test movie2", 2000))
        movies.add(Movie(emptyList(), emptyList(), 5, "test movie3", 2000))
        reposRepository.listOfMovies = movies;
        movieSearchViewModel.fetchMovies("test movie3")
        Thread.sleep(2000)
        Assert.assertEquals(null, movieSearchViewModel.errorMessageLiveData.value)
        Assert.assertEquals("List should be empty",2, movieSearchViewModel.adapter.itemCount)           //Expecting one section item + one movie item
    }


    @Test
    fun filteringMoviesListTest() {
        val movieSearchViewModel = MovieSearchViewModel(reposRepository)
        Assert.assertNull("Error is not null on start", movieSearchViewModel.errorMessageLiveData.value)
        val movies = ArrayList<Movie>()
        movies.add(Movie(emptyList(), emptyList(), 5, "test movie", 2000))
        movies.add(Movie(emptyList(), emptyList(), 5, "abc movie", 2000))
        movies.add(Movie(emptyList(), emptyList(), 5, "123 movie", 2000))
        reposRepository.listOfMovies = movies;
        val filteredList=movieSearchViewModel.getFilteredList(MovieListResponse(movies),"test")
        Assert.assertEquals("Size should be one with query test",1,filteredList.size)
    }

    @Test
    fun sortedAndSectionedMoviesListTest() {
        val movieSearchViewModel = MovieSearchViewModel(reposRepository)
        Assert.assertNull("Error is not null on start", movieSearchViewModel.errorMessageLiveData.value)
        val movies = ArrayList<Movie>()
        movies.add(Movie(emptyList(), emptyList(), 5, "test movie", 2000))
        movies.add(Movie(emptyList(), emptyList(), 5, "abc movie", 2010))
        movies.add(Movie(emptyList(), emptyList(), 4, "123 movie", 2010))
        movies.add(Movie(emptyList(), emptyList(), 1, "12 movie", 2012))
        movies.add(Movie(emptyList(), emptyList(), 5, "1 movie", 2012))
        reposRepository.listOfMovies = movies;
        val sortedSectionedMap=movieSearchViewModel.getPresentableList(movies)
        Assert.assertEquals("Three sections + five movies expected",8,sortedSectionedMap.size)
        Assert.assertEquals("First section should be 2012","2012",sortedSectionedMap[0].getTitle())
        Assert.assertEquals("First movie should be 1 movie because of high rating and year","1 movie",sortedSectionedMap[1].getTitle())
        Assert.assertEquals("Last item should be 2010 should be test movie","test movie",sortedSectionedMap[7].getTitle())
    }
}