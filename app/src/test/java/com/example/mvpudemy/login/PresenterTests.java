package com.example.mvpudemy.login;


import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyZeroInteractions;
import static org.mockito.Mockito.when;

public class PresenterTests {

    // TODO 1: Setup required objects (they will be the mock objects)
    /**
     * Notice that for the model and view we are using the interface rather than the concrete implementation;
     * except for the user and presenter. The reason for not using concrete implementations is pretty
     * simple,it is easier to mock interfaces with mockito.
     */
    LoginActivityMVP.Model mockLoginModel;
    LoginActivityMVP.View mockView;
    /**
     * However, we are going to test the presenter interactions, so while using the presenter interface in the field,
     * we will be actually using the concrete implementation of our presenter.
     * We set up the presenter as an interface to ensure that the contract between the implementation
     * and the interfaces matches.
     */
    LoginActivityPresenter presenter;
    User user;


    /**
     * The @before annotation tells junit, "every time you run a test, I want you to run this method first."
     * This is typically known as setup method. But it may have any name.
     * The setup annotated with @Before will reset the state of our objects to ensure that our next
     * test that is run, is not affected by previous tests.
     * >>> This method will be run for every test.
     */
    @Before
    public void setup() {

        mockLoginModel = mock(LoginActivityMVP.Model.class);

        user = new User("Fox", "Mulder");

        // When somebody calls the repository with the getUser method, returns the user object defined above.
        // TODO uncomment this line below to verify no interaction
        // when(mockLoginModel.getUser()).thenReturn(user);

        // Mock object for the view.
        mockView = mock(LoginActivityMVP.View.class);

        presenter = new LoginActivityPresenter(mockLoginModel);

        presenter.setView(mockView);

    }


    @Test
    public void noInteractionWithView() {
        presenter.getCurrentUser();
        verifyZeroInteractions(mockView);
    }


    @Test
    public void loadUserFromRepositoryWhenValidUserIsPresent() {
        // Make the getUser() return the User object from the setup method.
        when(mockLoginModel.getUser()).thenReturn(user);

        // Call the getCurrentUser() from the Presenter."
        // The getCurrentUser() method will create a User object and update it by calling "model.getUser()"
        //... AND if this user returned from the model IS NOT NULL, then use this user to update the view
        //... calling "view.setFirstName(user.getFirstName())" and "view.setLastName(user.getLastName())"
        presenter.getCurrentUser();

        // Verify model interactions, if the method getUser was called in the model one time.
        verify(mockLoginModel, times(1)).getUser();
        // Verify view interactions
        // Verify if the methods setFirstName() and setLastName() were called at the view 1 time each one
        verify(mockView, times(1)).setFirstName("Fox");
        verify(mockView, times(1)).setLastName("Mulder");
        // verify if the showUserNotAvailable method was never called
        verify(mockView, never()).showUserNotAvailable();
    }


    @Test
    public void shouldShowErrorMessageWhenUserIsNull() {
        // Make the getUser() return a NULL User object.
        when(mockLoginModel.getUser()).thenReturn(null);

        presenter.getCurrentUser();

        // Verify model interactions
        verify(mockLoginModel, times(1)).getUser();
        // Verify view interactions
        verify(mockView, never()).setFirstName("Fox");
        verify(mockView, never()).setLastName("Mulder");
        verify(mockView, times(1)).showUserNotAvailable();
    }


    @Test
    public void shouldCreateErrorMessageIfInputFieldIsEmpty() {

        // We have instructed Mockito to return an empty value from our mock view when
        // ...getFirstName method is called.
        when(mockView.getFirstName()).thenReturn("");

        // Try to save the use from the presenter
        presenter.saveUser();
        // Then... verify the correct behavior
        verify(mockView, times(1)).getFirstName();
        verify(mockView, never()).getLastName();
        verify(mockView, times(1)).showInputError();

        // Now tell mockView to return a value for first name and an empty for last name.
        when(mockView.getFirstName()).thenReturn("Dana");
        when(mockView.getLastName()).thenReturn("");

        presenter.saveUser();

        verify(mockView, times(2)).getFirstName();
        verify(mockView, times(1)).getLastName();
        verify(mockView, times(2)).showInputError();

    }


    @Test
    public void shouldBeAbleToSaveValidUser() {

        // Request the view to return the first name and last name
        when(mockView.getFirstName()).thenReturn("Jesse");
        when(mockView.getLastName()).thenReturn(("Lima"));

        // Call the saveUser from the presenter.
        // The saveUser() will do these tasks:
            // CHECK is the view is null. If not null ...
            //... CHECK if the inputs are not empty. If one filed is empty it will call the showInputError()
            //... CHECK if the user is valid, call the createUser() from the model. The createUser()
            //... will receive as argument the fistName and lastName from the view.
            //... if the inputs are valid the showUserSavedMessage() will be called.
        presenter.saveUser();

        // Verify if the user have been saved one more time (the second time)
        verify(mockView, times(2)).getFirstName();
        verify(mockView, times(2)).getLastName();

        // Verify if the createUser() was called one time from the model and saved in the repository.
        verify(mockLoginModel, times(1)).createUser("Jesse", "Lima");

        // Verify if the showUserSavedMessage(0 was called one time after the user was saved.
        verify(mockView, times(1)).showUserSavedMessage();
    }



}
