package com.example.mvpudemy.login;

/**
 * Created by JesseFariasdeLima on 3/6/2019.
 * This is a part of the project mvp-udemy.
 */
public class LoginModel implements LoginActivityMVP.Model{

    /**
     * Create a private field holding the reference to repository.
     * and sets up our repository field it in its constructor.
     */
    private LoginRepository loginRepository;

    /**
     * We then create a constructor that takes this LoginRepository as an argument
     * and sets up our repository field it in its constructor.
     */
    public LoginModel(LoginRepository loginRepository) {
        this.loginRepository = loginRepository;
    }


    @Override
    public void createUser(String firstName, String lastName) {
        loginRepository.saveUser(new User(firstName, lastName));
    }

    @Override
    public User getUser() {
        return loginRepository.getUser();
    }
}
