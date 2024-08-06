package com.example.marvel;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class QuizActivity extends AppCompatActivity {

    private int currentQuestionIndex = 0;
    private int score = 0;

    private final int[] images = new int[]{
            R.drawable.spider,
            R.drawable.spider2,
    };

    private final String[][] answers = {
            {"Iron Man", "Captain America", "Thor", "Hulk"},
            {"Black Widow", "Scarlet Witch", "Gamora", "Nebula"}
    };

    private final int[] correctAnswers = {0, 1}; // Indexes of correct answers

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) ImageView characterImage = findViewById(R.id.character_image);
        RadioGroup answersGroup = findViewById(R.id.answers_group);
        Button submitButton = findViewById(R.id.submit_button);

        loadQuestion(characterImage, answersGroup);

        submitButton.setOnClickListener(view -> {
            int selectedId = answersGroup.getCheckedRadioButtonId();
            if (selectedId == -1) {
                Toast.makeText(QuizActivity.this, "Please select an answer", Toast.LENGTH_SHORT).show();
                return;
            }

            RadioButton selectedAnswer = findViewById(selectedId);
            int answerIndex = answersGroup.indexOfChild(selectedAnswer);

            if (answerIndex == correctAnswers[currentQuestionIndex]) {
                score++;
            }

            currentQuestionIndex++;

            if (currentQuestionIndex < images.length) {
                loadQuestion(characterImage, answersGroup);
            } else {
                Intent intent = new Intent(QuizActivity.this,ScoreActivity.class);
                intent.putExtra("SCORE", score);
                startActivity(intent);
                finish();
            }
        });
    }

    private void loadQuestion(ImageView characterImage, RadioGroup answersGroup) {
        characterImage.setImageResource(images[currentQuestionIndex]);
        answersGroup.removeAllViews();

        for (String answer : answers[currentQuestionIndex]) {
            RadioButton radioButton = new RadioButton(this);
            radioButton.setText(answer);
            answersGroup.addView(radioButton);
        }
    }
}