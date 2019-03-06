package com.example.mvpudemy.login;


import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;
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
}
