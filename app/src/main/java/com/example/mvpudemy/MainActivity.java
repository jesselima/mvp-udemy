package com.example.mvpudemy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.mvpudemy.movies.models.Movie;
import com.example.mvpudemy.movies.MovieAPI;
import com.example.mvpudemy.movies.models.Result;
import com.example.mvpudemy.root.App;

import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Inject
    MovieAPI movieAPI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ((App) getApplication()).getApplicationComponent().inject(this);

        Call<Movie> movieAPICall = movieAPI.getMovies(BuildConfig.API_KEY);
        movieAPICall.enqueue(new Callback<Movie>() {
            @Override
            public void onResponse(Call<Movie> call, Response<Movie> response) {

                List<Result> movieList = response.body().getResults();

                Log.d("RESPONSE >>>>: ",response.body().getResults().toString());

                for (Result result : movieList) {
                    Log.d("========", "========");
                    Log.d("Original Title >>>: ", result.getOriginalTitle());
                    Log.d("Release Date >>>: ", result.getReleaseDate());
                    Log.d("OverView >>>: ", result.getOverview());
                }
            }

            @Override
            public void onFailure(Call<Movie> call, Throwable t) {
                t.printStackTrace();
            }
        });

    }
}
