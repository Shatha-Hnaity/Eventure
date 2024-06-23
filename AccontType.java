package com.example.eventurestartup;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class AccontType extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_accont_type);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main),
                (v, insets) -> {
                    Insets systemBars =
                            insets.getInsets(WindowInsetsCompat.Type.systemBars());
                    v.setPadding(systemBars.left, systemBars.top, systemBars.right,
                            systemBars.bottom);
                    return insets;
                });
        Button explorer_button = findViewById(R.id.event_explorer_button);
        Button organizer_button = findViewById(R.id.event_organizer_button);
        ImageView admin_button = findViewById(R.id.admin_button_asset);
        explorer_button.setOnClickListener(v -> startActivity(new
                Intent(AccountTypeScreen.this, ExplorerLoginScreen.class)));
        organizer_button.setOnClickListener(v -> startActivity(new
                Intent(AccountTypeScreen.this, OrganizerLoginScreen.class)));
        admin_button.setOnClickListener(v -> startActivity(new
                Intent(AccountTypeScreen.this, AdminLoginScreen.class)));
    }
}
