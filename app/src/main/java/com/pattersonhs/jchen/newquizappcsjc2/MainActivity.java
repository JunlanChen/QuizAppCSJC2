package com.pattersonhs.jchen.newquizappcsjc2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {
    RadioButton trueButton;
    RadioButton falseButton;
    Button nextButton;
    TextView questionText;
    Question question1;
    Question question2;
    Question question3;
    Question question4;
    Question question5;
    int toastMessageID;
    Question[] questions;
    int currentIndex;
    Question currentQ;
    final String TAG = "aaaaaaaaaaaaaaaaa";
    int score;


    //TextView rightAnswer;
    //TextView wrongAnswer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        trueButton = (RadioButton) findViewById(R.id.Truebutton);
        falseButton = (RadioButton) findViewById(R.id.Falsebutton);
        questionText = (TextView) findViewById(R.id.quiz);
        nextButton = (Button) findViewById(R.id.NextButton);
        currentIndex = 0;
        score = 0;
        //rightAnswer = (TextView) findViewById(R.id.rightAnswer);
        //wrongAnswer = (TextView)findViewById(R.id.wrongAnswer);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("message");

        myRef.setValue("Hello, World!");

        question1 = new Question("Computer Science is the study of computer",false);
        question2 = new Question("The CPU is responsible for executing instructions for the computer",true);
        question3 = new Question("Each computer has its own machine language which is made of stream of 0s and 1s",true);
        question4 = new Question("Pseudo-code uses exact programming language syntax to represent a module in the larger program", false);
        question5 = new Question("Every program must have exactly one function named main",true);
        questions = new Question[5];
        questions[0] = question1;
        questions[1] = question2;
        questions[2] = question3;
        questions[3] = question4;
        questions[4] = question5;
        currentQ = questions[currentIndex];
        trueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean givenAnswer = true;
                if (givenAnswer == currentQ.isCorrectAnswer())
                {
                    toastMessageID = R.string.right_toast;
                }
                else {
                    toastMessageID = R.string.wrong_toast;
                }
                Toast.makeText(MainActivity.this,toastMessageID,Toast.LENGTH_SHORT).show();
            }

        });
        falseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean givenAnswer = false;
                if (givenAnswer == currentQ.isCorrectAnswer())
                {
                    toastMessageID = R.string.right_toast;
                }
                else {
                    toastMessageID = R.string.wrong_toast;
                }
                Toast.makeText(MainActivity.this,toastMessageID,Toast.LENGTH_SHORT).show();
            }

        });

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentIndex = (currentIndex +1 );
                questionText.setText(currentQ.getQuestion());
                if(currentIndex >= 5) {
                    Intent scoreIntent1 = new Intent(MainActivity.this, ScoreActivity.class);
                    startActivity(scoreIntent1);
                }
                else
                {
                    currentQ = questions[currentIndex];
                }
            }
        });

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value = dataSnapshot.getValue(String.class);
                Log.d(TAG, "Value is: " + value);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });
    }


    //public void onClick(View view) {
    // Intent scoreIntent1 = new Intent(MainActivity.this, Main2Activity.class);
    //startActivity(scoreIntent1);
    // }
    //   public void onClick2(View view) {
    //Intent scoreIntent2 = new Intent(MainActivity.this, Main3Activity.class);
    //startActivity(scoreIntent2);
    // }




}
