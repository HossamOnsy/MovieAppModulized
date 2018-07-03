package com.sam.movieappmodulizedversion.MainActivity;

import android.content.Context;
import android.util.Log;

import com.sam.movieappmodulizedversion.models.MovieList;
import com.sam.movieappmodulizedversion.models.MovieModel;

import java.util.List;

public class MainPresenterImpl implements MoviesInteractor.OnFinishedListener, MainPresenter {
    MainView mainView;
    MoviesInteractorImpl moviesInteractor;
    Context context;

    public MainPresenterImpl(MainView mainView,Context context) {
        this.mainView = mainView;
        this.context = context;
    }



    @Override
    public void onCreate() {
        Log.v("Hellooooz", "MainPresenter onCreate --->  " );
        this.moviesInteractor= new MoviesInteractorImpl(this.context);

        this.moviesInteractor.getMovies(this);
    }

    @Override
    public void onDestroy() {

    }

    @Override
    public void onFinished(MovieList movieModels) {
        Log.v("Hellooooz", "MainPresenter onFinished --->  TotalPages --> " +movieModels.getTotalPages());
        this.mainView.fetchedMovies(movieModels);
    }
}
