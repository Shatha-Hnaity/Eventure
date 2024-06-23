package com.example.eventurestartup;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_splash_screen);
        ImageView imageView = findViewById(R.id.eventure_logo_brand);
        Glide.with(this).asGif().load(R.drawable.eventure_logo_brand).into(imageView)
        ;
// Example: Delay for 5 seconds and then start the main activity
        new android.os.Handler().postDelayed(
                new Runnable() {
                    public void run() {
                        Intent mainIntent = new Intent(SplashScreen.this,
                                startActivity(mainIntent);
                        finish();
                        WelcomeScreen.class);
                    }
                },
                5000
        );
    };
}