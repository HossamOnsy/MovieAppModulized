package com.sam.movieappmodulizedversion.MainActivity;


import android.content.Context;
import android.util.Log;

import com.sam.movieappmodulizedversion.NetworkClient;
import com.sam.movieappmodulizedversion.NetworkInterface;
import com.sam.movieappmodulizedversion.models.MovieList;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

public class MoviesInteractorImpl implements MoviesInteractor {
    Context context;
    private String TAG = "Hellooooz";

    public MoviesInteractorImpl(Context context) {
        this.context = context;
    }

    @Override
    public void getMovies(final OnFinishedListener listener) {

        NetworkInterface apiService = NetworkClient.getRetrofit()
                .create(NetworkInterface.class);
        Log.v("Hellooooz", "MoviesInteractorImpl getMovies ---> ");

        apiService.getPopularMovieList("popular", "209e7f32c6009634ea6bcb286952ea3d")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableObserver<MovieList>() {
                    @Override
                    public void onNext(MovieList value) {
                        Log.v("Hellooooz", "value --->  " + value.getPage());
                        listener.onFinished(value);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.v("Hellooooz", "Throwable --->  " + e.getMessage());

                    }

                    @Override
                    public void onComplete() {
                        Log.v("Hellooooz", "Completed --->  ");

                    }
                });

    }
}
