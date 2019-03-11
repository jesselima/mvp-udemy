package com.example.mvpudemy.movies;


import com.example.mvpudemy.movies.models.Movie;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

public interface MovieAPI {

    @GET("discover/movie")
    Call<Movie> getMovies(@Query(ApiConfig.UrlParamKey.API_KEY) String api_key );

    // It points to the same endpoint but this time it will return an observable of twitch rather
    // than a call object as it did in the original implementation.
    @GET("discover/movie")
    Observable<Movie> getMoviesObservable(@Query(ApiConfig.UrlParamKey.API_KEY) String api_key );

}
