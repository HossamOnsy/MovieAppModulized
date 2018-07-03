package com.sam.movieappmodulizedversion.MainActivity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.sam.movieappmodulizedversion.R;
import com.sam.movieappmodulizedversion.adapter.MoviesAdapter;
import com.sam.movieappmodulizedversion.models.MovieList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class MainActivity extends AppCompatActivity implements MainView {
    Unbinder unbinder;
    MainPresenterImpl mainPresenter;
    @BindView(R.id.rv_movies)
    RecyclerView recyclerView;

    MoviesAdapter moviesAdapter;
    MovieList movieList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainPresenter = new MainPresenterImpl(this,this);
        mainPresenter.onCreate();

        initiateView();
    }

    private void initiateView() {
        unbinder = ButterKnife.bind(this);

        movieList = new MovieList();
        moviesAdapter = new MoviesAdapter(movieList, this);
        recyclerView.setAdapter(moviesAdapter);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(this,2));
    }

    @Override
    protected void onDestroy() {
        if (unbinder != null)
            unbinder.unbind();
        super.onDestroy();

    }

    @Override
    public void fetchedMovies(MovieList movieModels) {
        Log.v("Hellooooz", "fetchedMovies onFinished --->  TotalPages --> " +movieModels.getTotalPages());

        movieList = movieModels;
//        moviesAdapter.notifyDataSetChanged();
        moviesAdapter = new MoviesAdapter(movieList,this);
        recyclerView.setAdapter(moviesAdapter);
    }
}
