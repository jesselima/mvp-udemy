package com.example.mvpudemy.root;

import android.app.Application;

/**
 * We need to define an application object where dagger will live throughout the entire life span of
 * the application.
 * We should do all these work within the application class since the instances should be declared
 * only once.
 * Here we are extending the application class and we are creating a private instance of the
 * ApplicationComponent.
 */
public class App extends Application {

     private ApplicationComponent applicationComponent;

     // We will also define an onCreate method here where the component will be instantiated by Dagger.
    @Override
    public void onCreate() {
        super.onCreate();

        applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();

    }

    // We will also define public getComponent function which will return the application component instance.
    public ApplicationComponent getApplicationComponent () {
        return applicationComponent;
    }

}
