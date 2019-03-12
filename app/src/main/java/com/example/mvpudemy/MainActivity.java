package com.example.mvpudemy;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.example.mvpudemy.movies.MovieAPI;
import com.example.mvpudemy.movies.models.Movie;
import com.example.mvpudemy.movies.models.Result;
import com.example.mvpudemy.root.App;

import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    @Inject
    MovieAPI movieAPI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ((App) getApplication()).getApplicationComponent().inject(this);

        // ################### CONVENTIONAL API CALL WITH RETROFIT #################################
        Call<Movie> movieAPICall = movieAPI.getMovies(BuildConfig.API_KEY);
        movieAPICall.enqueue(new Callback<Movie>() {
            @Override
            public void onResponse(@NonNull Call<Movie> call, @NonNull Response<Movie> response) {

                List<Result> movieList = response.body() != null ? response.body().getResults() : null;
                if (movieList != null) {
                    for (Result result : movieList) {
                        Log.d("========", "========");
                        Log.d("Without Rx >>>: ", result.getOriginalTitle());
                    }
                }

            }

            @Override
            public void onFailure(Call<Movie> call, Throwable t) {
                t.printStackTrace();
            }
        });

        // ################ API CALL WITH RETROFIT AND RxJava using Observables ####################
        movieAPI.getMoviesObservable(BuildConfig.API_KEY)
                .flatMap((Func1<Movie, Observable<Result>>) movie -> {
                    return Observable.from(movie.getResults()); // The list of movies are here.
                })
                .flatMap((Func1<Result, Observable<String>>) result -> Observable.just(result.getOriginalTitle()))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                // Applying filter operator
                .filter(s -> s.startsWith("C"))
                // /\/\/\/\
                .subscribe(new Observer<String>() {
                    @Override
                    public void onCompleted() {
                        Toast.makeText(MainActivity.this, "List finished loading!", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                    }

                    @Override
                    public void onNext(String s) {
                        Log.d("########", "#########");
                        Log.d("####with", " filter for title starting with 'C' ");
                        Log.d("Emitted from Observer: ", s);
                    }
                });

    }
}
