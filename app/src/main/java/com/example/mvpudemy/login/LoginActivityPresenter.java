package com.example.mvpudemy.login;

import android.support.annotation.Nullable;
import android.util.Log;

/**
 * the LoginActivityPresenter. It usually implements the LoginActivityMVP.Presenter interface
 * with the methods we’ve already defined in the interface of LoginActivityMVP.
 */
public class LoginActivityPresenter implements LoginActivityMVP.Presenter {

    /**
     * Here we create a private variable for our view instance which we can talk to or control from
     * our presenter.
     * In order for this to work we need to set the our view field to the View instance
     * that is passed in from the onResume method we coded previously.
     *
     * Notice that we have added an annotation @nullable to the view field.
     * This is a just a JLint hint to help us check for null reference whenever we access the view field.
     * Due to lifecycle events we may not be sure that the ‘view’ exists and the activity may have
     * been destroyed by the operating system.
     */
    @Nullable
    private LoginActivityMVP.View view;

    /**
     * We will then create another private variable called model so that we can communicate with the
     * model from the presenter.
     */
    private LoginActivityMVP.Model model;

    /**
     * Notice that in our constructor we are taking in the model as an argument.
     * This will be setup using dependency injection by Dagger. this type of injection is called
     * "constructor injection".
     * We will wire everything up with Dagger shortly.
     * Notice that we have added an annotation @Nullable to the view field.
     */
    public LoginActivityPresenter(LoginActivityMVP.Model model) {
        this.model = model;
    }

    @Override
    public void setView(LoginActivityMVP.View view) {
        this.view = view;
    }

    @Override
    public void loginButtonClicked() {
        if (view != null) {
            if (view.getFirstName().trim().equals("") || view.getLastName().trim().equals("")) {
                view.showInputError();
            }else {
                model.createUser(view.getFirstName(), view.getLastName());
                view.showUserSavedMessage();
            }
        }
    }

    @Override
    public void getCurrentUser() {
        User user = model.getUser();

        if (user == null) {
            if (view!= null) {
                view.showUserNotAvailable();
            }
        }else {
            if (view!= null) {
                view.setFirstName(user.getFirstName());
                view.setLastName(user.getLastName());
            }
        }
    }
}
