package com.example.eventure.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.eventure.R;
import com.example.eventure.model.contract.EventOrganizerLoginContract;
import com.example.eventure.presenter.EventOrganizerLoginPresenter;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class EventOrganizerLogin extends AppCompatActivity implements EventOrganizerLoginContract.View {
    private FirebaseAuth mAuth;
    private EventOrganizerLoginPresenter presenter;

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if (currentUser != null) {
            currentUser = null;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_event_organizer_login);


        presenter = new EventOrganizerLoginPresenter(this);
        mAuth = FirebaseAuth.getInstance();
        Button loginButton = findViewById(R.id.event_organizer_login_button);
        TextView goToSignUp = findViewById(R.id.event_organizer_login_create_an_account);
        EditText usernameInput = findViewById(R.id.event_organizer_login_username_input);
        EditText passwordInput = findViewById(R.id.event_organizer_login_password_input);

        TextView forgetPasswordButton = findViewById(R.id.event_organizer_login_forgot_password);
        goToSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navigateToSignUp();
            }
        });
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = usernameInput.getText().toString();
                String password = passwordInput.getText().toString();
                if (presenter.handleLogin(username, password)) {
                    signIn(username, password);
                }
            }

        });
        forgetPasswordButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navigateToForgotPassword();
            }
        });

    }


    @Override
    public void navigateToForgotPassword() {
        startActivity(new Intent(getApplicationContext(), ForgotPassword.class));
    }

    @Override
    public void navigateToEventOrganizerHome() {
        startActivity(new Intent(getApplicationContext(), EventOrganizerHomeScreen.class));
    }

    @Override
    public void navigateToSignUp() {
        startActivity(new Intent(getApplicationContext(), EventOrganizerSignUp.class));
    }

    @Override
    public void showLoginError(String errorMessage) {
        Toast.makeText(getApplicationContext(), errorMessage, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void signIn(String email, String password) {
        mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    FirebaseUser user = mAuth.getCurrentUser();
                    navigateToEventOrganizerHome();
                } else {
                    // If sign in fails, display a message to the user.
                    Toast.makeText(getApplicationContext(), "Authentication failed.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}