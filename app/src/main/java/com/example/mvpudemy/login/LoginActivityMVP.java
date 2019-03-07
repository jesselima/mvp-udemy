package com.example.mvpudemy.login;

/**
 *
 */
public interface LoginActivityMVP {

    interface View {

        // The presenter and the interface do not care about who implement this.

        String getFirstName();
        String getLastName();
        // Warning message
        void showUserNotAvailable();
        void showInputError();
        void showUserSavedMessage();

        void setFirstName(String firstName);
        void setLastName(String lastName);

    }

    interface Presenter {
        // setup the view.
        void setView(LoginActivityMVP.View view);
        // Usually when we have buttons inside our view - we instruct the presenter to handle the
        // click events for our buttons
        void loginButtonClicked();

        void getCurrentUser();

        void saveUser();
    }

    interface Model {

        // Our Model interface creates a user taking two string arguments- First name (firstName)
        // and last name (lastName).
        void createUser(String firstName, String lastName);

        // This method is just forwarding the request to the repository because we don’t have any
        // business logic to apply in our view model.
        User getUser();
    }

}
