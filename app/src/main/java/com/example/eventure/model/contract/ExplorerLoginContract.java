package com.example.eventure.model.contract;

public interface ExplorerLoginContract {
    interface View {
        void showToast();
        void showLoginError(String message);
        void navigateToExplorerHome();
        void navigateToExplorerSignUp();
        void navigateToForgotPassword();

    }
    interface Presenter{
        void handleLogin(String email, String password);
        void validateLoginCredentials(String username, String password);
        void onDestroy();

    }

}
