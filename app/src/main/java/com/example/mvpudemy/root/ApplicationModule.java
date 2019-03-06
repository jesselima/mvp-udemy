package com.example.mvpudemy.root;

import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Jesse Farias de Lima on 3/5/2019.
 * This is a part of the project mvp-udemy.
 */
@Module
public class ApplicationModule {

    private Application application;

    public ApplicationModule(Application application) {
        this.application = application;
    }

    /*
     * The methods that will expose available return type should also be annotated with @provides decorator.
     * The Singleton annotation also signals to the Dagger compiler that the instance should be created only once in the application.
     */
    @Provides
    @Singleton
    public Context returnContext() {
        return application;
    }


}
