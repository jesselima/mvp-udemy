package com.example.mvpudemy.login;

import dagger.Module;
import dagger.Provides;

/**
 * This module is going to be a dagger class where we will provide the necessary methods for the
 * MVP module to work.
 */
@Module
public class LoginModule {

    /**
     * Now let's hook up the constructors so that dagger knows what to inject in at runtime.
     * We will declare a public method to our class called provide Login Activity Presenter and we
     * will add a “@provides” annotation to it.
     * When this method is called – it will return a new instance of LoginActivityPresenter
     * which is the implementation of our LoginActivityMVP.presenter interface.
     */
    @Provides
    public LoginActivityMVP.Presenter provideLoginActivityPresenter(LoginActivityMVP.Model model) {
        return new LoginActivityPresenter(model);
    }

    /**
     * The LoginActivityPresenter needs a model in its constructor – which we will pass right here.
     * Then we create another provider method which returns an instance of LoginActivityMVP.Model,
     * this will instruct dagger that if LoginActivityMVP.Model is requested then how to construct it.
     * Here the model is taking LoginRepository as an argument.
     * We write another method with a @provides annotation.
     */
    @Provides
    public LoginActivityMVP.Model provideLoginActivityModel(LoginRepository loginRepository) {
        return new LoginModel(loginRepository);
    }

    /**
     * We write another method with a @provides annotation.
     * And this method provides instance of loginRepository ; we will call this method provideLoginRepository()
     * And this will return a new MemoryRepository() If we compile and sync it we could see some errors.
     */
    @Provides
    public LoginRepository provideLoginRepository() {
        return new MemoryRepository();
    }



}
