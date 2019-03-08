package com.example.mvpudemy.movies;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class ApiModule {

    public final String BASE_URL = ApiConfig.getBaseApiUrl();

    // These methods can be used by dagger to provide an instance of our MovieAPI client.
    /**
     * The last method is the provide a MovieAPI service interface method which returns an instance of our MovieAPI
     * interface by calling the create method.
     * @return a MovieAPI service.
     */
    @Provides
    public MovieAPI provideApiService() {
        return provideRetrofit(BASE_URL, provideClient()).create(MovieAPI.class);
    }


    /**
     * Provides a Retrofit instance.
     * @param baseURL the base API URL
     * @param okHttpClient is the OkHttp client provided by the provideClient() method.
     * @return the retrofit instance.
     *
     * The argument OkHttpClient which in this example is necessary because we are using a custom
     * interceptor.
     */
    @Provides
    public Retrofit provideRetrofit(String baseURL, OkHttpClient okHttpClient) {
        return new Retrofit.Builder()
                .baseUrl(baseURL)
                .client(okHttpClient)
                // GsonConverterFactory will be responsible for deserialize the JSON data
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }


    /**
     * Provides a instance of OkHttp Client. This is used when we need a interceptor to the Retrofit Client
     * generally for logging purpose.
     */
    @Provides
    public OkHttpClient provideClient() {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        // The return will be a OkHttp Client instance with a interceptor already added to the client.
        return  new OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build();
    }

}
