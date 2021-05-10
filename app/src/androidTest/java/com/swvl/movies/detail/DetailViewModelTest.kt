package com.swvl.movies.detail

import com.swvl.movies.MockFlickrRepository
import com.swvl.movies.MockMovieRepository
import com.swvl.movies.data.model.Photo
import com.swvl.movies.data.repo.FlickrDataSource
import com.swvl.movies.data.repo.FlickrRepository
import com.swvl.movies.ui.detail.MovieDetailViewModel
import org.junit.Assert
import org.junit.Test

class DetailViewModelTest {

    private var reposRepository = MockFlickrRepository()


    @Test
    fun urlFromPhotoTest() {
        val detailViewModel = MovieDetailViewModel(reposRepository)
        val photo= Photo(farm = 66,id="51134542784",title = "Malgrat el desencontre idiomàtic de l’oralitat amb la gestualitat em va deixar fotografiar-lo quan ens vam trobar al mig del Passeig. Captura: La Rambla, Barcelona.",server = "65535",secret = "94547ffc35",owner =  "7489025@N06")

        Assert.assertEquals("https://farm66.static.flickr.com/65535/51134542784_94547ffc35.jpg",  detailViewModel.getUrlFromPhoto(photo))
    }

}