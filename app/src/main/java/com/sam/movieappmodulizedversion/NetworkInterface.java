package com.sam.movieappmodulizedversion;

import com.sam.movieappmodulizedversion.models.MovieList;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface NetworkInterface {

    @GET("3/movie/{popular}")
    Observable<MovieList> getPopularMovieList(@Path("popular") String path, @Query("api_key") String api_key);

    @GET("discover/movie")
    Observable<Object> getMovies(@Query("api_key") String api_key);
}