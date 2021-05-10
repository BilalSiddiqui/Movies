package com.swvl.movies.ui.find

import android.view.View

interface MovieItemClickListener {
  fun onMovieItemClicked(moviePresentationModel: RecyclerItem.MoviePresentationModel, view: View)
}