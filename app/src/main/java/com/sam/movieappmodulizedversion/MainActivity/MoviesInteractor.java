package com.sam.movieappmodulizedversion.MainActivity;

import com.sam.movieappmodulizedversion.models.MovieList;

public interface MoviesInteractor {


    interface OnFinishedListener {
        void onFinished(MovieList movieModels);
    }

    void getMovies(OnFinishedListener listener);
}
