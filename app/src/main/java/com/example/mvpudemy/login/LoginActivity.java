package com.example.mvpudemy.login;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mvpudemy.BuildConfig;
import com.example.mvpudemy.R;
import com.example.mvpudemy.movies.models.Movie;
import com.example.mvpudemy.movies.MovieAPI;
import com.example.mvpudemy.movies.models.Result;
import com.example.mvpudemy.root.App;

import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity implements LoginActivityMVP.View {

    // First create a lifecycle callback on Resume where we can set the presenter to this view.
    // in order to get the presenter in this class we need to declare an field to hold the instance of the presenter
    // also make the dagger aware of it so that it can inject the presenter at run time.
    @Inject
    LoginActivityMVP.Presenter presenter;

    // 1 - Inject the dependency of MovieAPI
    @Inject
    MovieAPI movieAPI;

    private EditText editTextFirstName;
    private EditText editTextLastName;
    private Button buttonLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ((App) getApplication()).getApplicationComponent().inject(this);

        Call<Movie> movieAPICall = movieAPI.getMovies(BuildConfig.API_KEY);
        movieAPICall.enqueue(new Callback<Movie>() {
            @Override
            public void onResponse(Call<Movie> call, Response<Movie> response) {
                List<Result> movieList = response.body().getResults();

                for (Result result : movieList) {
                    System.out.println(result.getTitle());
                }

            }

            @Override
            public void onFailure(Call<Movie> call, Throwable t) {
                t.printStackTrace();
            }
        });


        editTextFirstName   = findViewById(R.id.loginActivity_firstName_editText);
        editTextLastName    = findViewById(R.id.loginActivity_lastName_editText);
        buttonLogin         = findViewById(R.id.loginActivity_login_button);

        buttonLogin.setOnClickListener(v -> {
            // So in the onClick() method we need to call the presenter and inform it about the
            // button tapped event by invoking “presenter.loginButtonClicked()” then on the
            // onResume() method
            presenter.loginButtonClicked();
        });
    }


    @Override
    protected void onResume() {
        super.onResume();
        // When the activity is resumed Set the View to the presenter. After this we can use the
        // other methods implemented by the view
        presenter.setView(this);
        // let’s include the call to “presenter.getCurrentUser() that is If we want to get the
        // default user and display the default values in the text fields.
        presenter.getCurrentUser();
    }

    @Override
    public String getFirstName() {
        return editTextFirstName.getText().toString().trim();
    }

    @Override
    public String getLastName() {
        return editTextLastName.getText().toString().trim();
    }

    @Override
    public void showUserNotAvailable() {
        Toast.makeText(this, "Error. User not available!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showInputError() {
        Toast.makeText(this, "First or Last name can not be empty!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showUserSavedMessage() {
        Toast.makeText(this, "User saved successfully!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setFirstName(String firstName) {
        editTextFirstName.setText(firstName);
    }

    @Override
    public void setLastName(String lastName) {
        editTextLastName.setText(lastName);
    }
}
