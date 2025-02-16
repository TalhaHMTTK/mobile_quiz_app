package com.example.quizapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class QuizActivity extends AppCompatActivity {

    private TextView questionText;
    private RadioGroup optionsGroup;
    private Button nextButton, previousButton;

    private String[] questions = {
            "What is Java?",
            "Who developed Android?",
            "What does API stand for?",
            "Which one is a database?"
    };

    private String[][] options = {
            {"Programming Language", "Fruit", "Animal", "City"},
            {"Google", "Apple", "Microsoft", "IBM"},
            {"Application Programming Interface", "Apple Phone Interface", "Automated Process Integration", "Android Programming Interface"},
            {"MySQL", "Java", "Python", "CSS"}
    };

    private int[] correctAnswers = {0, 0, 0, 0}; // Index of correct answers

    private int currentIndex = 0;
    private int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        questionText = findViewById(R.id.question_text);
        optionsGroup = findViewById(R.id.options_group);
        nextButton = findViewById(R.id.next_button);
        previousButton = findViewById(R.id.prev_button);

        showQuestion();

        nextButton.setOnClickListener(view -> {
            checkAnswer();
            if (currentIndex < questions.length - 1) {
                currentIndex++;
                showQuestion();
            } else {
                Intent intent = new Intent(QuizActivity.this, ResultActivity.class);
                intent.putExtra("SCORE", score);
                startActivity(intent);
            }
        });

        previousButton.setOnClickListener(view -> {
            if (currentIndex > 0) {
                currentIndex--;
                showQuestion();
            }
        });
    }

    private void showQuestion() {
        questionText.setText(questions[currentIndex]);
        optionsGroup.removeAllViews();

        for (int i = 0; i < options[currentIndex].length; i++) {
            RadioButton radioButton = new RadioButton(this);
            radioButton.setText(options[currentIndex][i]);
            radioButton.setId(i);
            optionsGroup.addView(radioButton);
        }

        previousButton.setEnabled(currentIndex > 0);
    }

    private void checkAnswer() {
        int selectedId = optionsGroup.getCheckedRadioButtonId();
        if (selectedId == correctAnswers[currentIndex]) {
            score++;
        }
    }
}
