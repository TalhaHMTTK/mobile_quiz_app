package com.example.quizapp;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText nameInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameInput = findViewById(R.id.name_input);
        Button startButton = findViewById(R.id.start_button);

        startButton.setOnClickListener(view -> {
            String name = nameInput.getText().toString();
            Intent intent = new Intent(MainActivity.this, QuizActivity.class);
            intent.putExtra("USER_NAME", name);
            startActivity(intent);
        });
    }
}
