package com.example.eventure.presenter;

import com.example.eventure.model.contract.ExplorerLoginContract;

public class ExplorerLoginPresenter implements ExplorerLoginContract.Presenter {
    private ExplorerLoginContract.View view;

    public ExplorerLoginPresenter(ExplorerLoginContract.View view) {
        this.view = view;
    }



    @Override
    public void handleLogin(String email, String password) {
        if (email.equals("admin") && password.equals("admin")) {
            view.navigateToExplorerHome();  // On successful login, navigate to home
        } else {
            view.showLoginError("Invalid username or password");
        }
    }

    @Override
    public void validateLoginCredentials(String username, String password) {

    }


    @Override
    public void onDestroy() {
        view = null;

    }
}
