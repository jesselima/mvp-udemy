package com.example.mvpudemy.login;

/**
 *
 */
public interface LoginRepository {

    User getUser();
    void saveUser(User user);

}
