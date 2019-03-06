package com.example.mvpudemy.root;

import com.example.mvpudemy.login.LoginActivity;
import com.example.mvpudemy.login.LoginModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * We need to create an application component where dagger knows where to inject the dependencies to.
 * In dagger 2 the injector class is called Component.
 * This component assigns references in our activities, services, or fragments to have access to
 * singleton which we’ve already defined.
 */

/**
 * We will need to annotate this class with a @Component declaration and set the modules to
 * the module defined earlier. Note that activities, service or fragments that can be added
 * should be declared in this class with individual inject() methods.
 */
@Singleton
@Component(modules = { ApplicationModule.class, LoginModule.class })

public interface ApplicationComponent {

    void inject(LoginActivity target);

}
