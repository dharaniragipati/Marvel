package com.example.marvel;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ScoreActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        TextView scoreText = findViewById(R.id.score_text);
        Button playAgainButton = findViewById(R.id.play_again_button);

        int score = getIntent().getIntExtra("SCORE", 0);
        scoreText.setText("Your Score: " + score);

        playAgainButton.setOnClickListener(view -> {
            Intent intent = new Intent(ScoreActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        });
    }
}