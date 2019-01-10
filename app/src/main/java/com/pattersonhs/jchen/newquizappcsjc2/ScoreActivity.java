package com.pattersonhs.jchen.newquizappcsjc2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ScoreActivity extends AppCompatActivity {
    int score;
    TextView scoreview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);
        scoreview = (TextView) findViewById(R.id.scoreview);
        score = getIntent().getIntExtra("add",0);
        scoreview.setText(""+ score);
    }
}
