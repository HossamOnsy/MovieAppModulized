package com.sam.movieappmodulizedversion.MainActivity;

import com.sam.movieappmodulizedversion.models.MovieList;
import com.sam.movieappmodulizedversion.models.MovieModel;

import java.util.List;

public interface MainView {

    void fetchedMovies(MovieList movieModels);
}
