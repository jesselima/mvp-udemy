package com.example.mvpudemy.login;

/**
 * Created by JesseFariasdeLima on 3/6/2019.
 * This is a part of the project mvp-udemy.
 */
public class MemoryRepository implements LoginRepository {

    private User user;

    @Override
    public User getUser() {

        if (user == null) {
            User user = new User("Fox", "Mulder");
            user.setId(0);
            return user;
        }else {
            // If the user is not null we return the user that is saved in the instance
            return user;
        }
    }

    @Override
    public void saveUser(User user) {

        // Check is the user is not null.
        if (user == null) {
            // If is null we get the user instance already saved in memory.
            user = getUser();
        }

        this.user = user;
    }
}
