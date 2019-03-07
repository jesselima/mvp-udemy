package com.example.mvpudemy.login


import org.junit.Before
import org.junit.Test

import org.mockito.Mockito.mock
import org.mockito.Mockito.never
import org.mockito.Mockito.times
import org.mockito.Mockito.verify
import org.mockito.Mockito.`when`

class PresenterTests {

    // TODO - Just read comments below : Setup required objects (they will be the mock objects).
    /**
     * Notice that for the model and view we are using the interface rather than the concrete implementation;
     * except for the user and presenter. The reason for not using concrete implementations is pretty
     * simple,it is easier to mock interfaces with mockito.
     */
    private lateinit var mockLoginModel: LoginActivityMVP.Model
    private lateinit var mockView: LoginActivityMVP.View
    /**
     * However, we are going to test the presenter interactions, so while using the presenter interface in the field,
     * we will be actually using the concrete implementation of our presenter.
     * We set up the presenter as an interface to ensure that the contract between the implementation
     * and the interfaces matches.
     */
    private lateinit var presenter: LoginActivityPresenter
    private lateinit var user: User


    /**
     * The @before annotation tells junit, "every time you run a test, I want you to run this method first."
     * This is typically known as setup method. But it may have any name.
     * The setup annotated with @Before will reset the state of our objects to ensure that our next
     * test that is run, is not affected by previous tests.
     * >>> This method will be run for every test.
     */
    @Before
    fun setup() {

        mockLoginModel = mock(LoginActivityMVP.Model::class.java)

        user = User("Fox", "Mulder")

        // When somebody calls the repository with the getUser method, returns the user object defined above.
        `when`(mockLoginModel.user).thenReturn(user)

        // Mock object for the view.
        mockView = mock(LoginActivityMVP.View::class.java)

        // The constructor of my presenter must receive a model as argument.
        presenter = LoginActivityPresenter(mockLoginModel)

        presenter.setView(mockView)

    }


    @Test
    fun loadUserFromRepositoryWhenValidUserIsPresent() {
        // Make the getUser() return the User object from the setup method.
        `when`(mockLoginModel.user).thenReturn(user)

        // Call the getCurrentUser() from the Presenter."
        // The getCurrentUser() method will create a User object and update it by calling "model.getUser()"
        //... AND if this user returned from the model IS NOT NULL, then use this user to update the view
        //... calling "view.setFirstName(user.getFirstName())" and "view.setLastName(user.getLastName())"
        presenter.getCurrentUser()

        // Verify model interactions, if the method getUser was called in the model one time.
        verify<LoginActivityMVP.Model>(mockLoginModel, times(1)).getUser()
        // Verify view interactions
        // Verify if the methods setFirstName() and setLastName() were called at the view 1 time each one
        verify<LoginActivityMVP.View>(mockView, times(1)).setFirstName("Fox")
        verify<LoginActivityMVP.View>(mockView, times(1)).setLastName("Mulder")
        // verify if the showUserNotAvailable method was never called
        verify<LoginActivityMVP.View>(mockView, never()).showUserNotAvailable()
    }


    @Test
    fun shouldShowErrorMessageWhenUserIsNull() {
        // Make the getUser() return a NULL User object.
        `when`(mockLoginModel.user).thenReturn(null)

        presenter.getCurrentUser()

        // Verify model interactions
        verify<LoginActivityMVP.Model>(mockLoginModel, times(1)).getUser()
        // Verify view interactions
        verify<LoginActivityMVP.View>(mockView, never()).setFirstName("Fox")
        verify<LoginActivityMVP.View>(mockView, never()).setLastName("Mulder")
        verify<LoginActivityMVP.View>(mockView, times(1)).showUserNotAvailable()
    }


    @Test
    fun shouldCreateErrorMessageIfInputFieldIsEmpty() {

        // We have instructed Mockito to return an empty value from our mock view when
        // ...getFirstName method is called.
        `when`(mockView.firstName).thenReturn("")

        // Try to save the use from the presenter
        presenter.saveUser()
        // Then... verify the correct behavior
        verify<LoginActivityMVP.View>(mockView, times(1)).getFirstName()
        verify<LoginActivityMVP.View>(mockView, never()).getLastName()
        verify<LoginActivityMVP.View>(mockView, times(1)).showInputError()

        // Now tell mockView to return a value for first name and an empty for last name.
        `when`(mockView.firstName).thenReturn("Dana")
        `when`(mockView.lastName).thenReturn("")

        presenter.saveUser()

        verify<LoginActivityMVP.View>(mockView, times(2)).getFirstName()
        verify<LoginActivityMVP.View>(mockView, times(1)).getLastName()
        verify<LoginActivityMVP.View>(mockView, times(2)).showInputError()

    }


    @Test
    fun shouldBeAbleToSaveValidUser() {

        // Request the view to return the first name and last name
        `when`(mockView.firstName).thenReturn("Jesse")
        `when`(mockView.lastName).thenReturn("Lima")

        // Call the saveUser from the presenter.
        // The saveUser() will do these tasks:
        // CHECK is the view is null. If not null ...
        //... CHECK if the inputs are not empty. If one filed is empty it will call the showInputError()
        //... CHECK if the user is valid, call the createUser() from the model. The createUser()
        //... will receive as argument the fistName and lastName from the view.
        //... if the inputs are valid the showUserSavedMessage() will be called.
        presenter.saveUser()

        // Verify if the user have been saved one more time (the second time)
        verify<LoginActivityMVP.View>(mockView, times(2)).getFirstName()
        verify<LoginActivityMVP.View>(mockView, times(2)).getLastName()

        // Verify if the createUser() was called one time from the model and saved in the repository.
        verify<LoginActivityMVP.Model>(mockLoginModel, times(1)).createUser("Jesse", "Lima")

        // Verify if the showUserSavedMessage(0 was called one time after the user was saved.
        verify<LoginActivityMVP.View>(mockView, times(1)).showUserSavedMessage()
    }


    @Test
    fun shouldShowInputErrorMessageWhenFieldsAreEmpty() {

        `when`(mockView.firstName).thenReturn("")
        `when`(mockView.lastName).thenReturn("")

        `when`(mockLoginModel.user).thenReturn(user)

        presenter.loginButtonClicked()

        verify<LoginActivityMVP.View>(mockView, times(1)).showInputError()

    }

    @Test
    fun shouldCallCreateUserAndShowUserSavedMessageWhenInputIsCorrect() {

        `when`(mockView.firstName).thenReturn("Jesse")
        `when`(mockView.lastName).thenReturn("Lima")

        `when`(mockLoginModel.user).thenReturn(user)

        presenter.loginButtonClicked()

        verify<LoginActivityMVP.Model>(mockLoginModel, times(1)).createUser("Jesse", "Lima")
        verify<LoginActivityMVP.View>(mockView, times(1)).showUserSavedMessage()

    }
}
