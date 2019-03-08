package com.example.mvpudemy.movies;


import com.example.mvpudemy.movies.models.Movie;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MovieAPI {

    @GET("discover/movie")
    Call<Movie> getMovies(@Query("api_key") String api_key );

}
