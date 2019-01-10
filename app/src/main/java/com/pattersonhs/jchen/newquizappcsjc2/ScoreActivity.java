package com.pattersonhs.jchen.newquizappcsjc2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ScoreActivity extends AppCompatActivity {
    int score;
    TextView scoreview;
    Button reset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);
        scoreview = (TextView) findViewById(R.id.scoreview);
        reset = (Button) findViewById(R.id.reset);
        score = getIntent().getIntExtra("add",0);
        scoreview.setText(""+ score);

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent resetIntent = new Intent(ScoreActivity.this, MainActivity.class);
                startActivity(resetIntent);
            }
        });
    }
}
