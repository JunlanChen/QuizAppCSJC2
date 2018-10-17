package com.pattersonhs.jchen.quizappcsjc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    RadioButton trueButton;
    RadioButton falseButton;
    TextView questionText;
    Question question1;
    Question question2;
    Question question3;
    Question question4;
    Question question5;
    int toastMessageID;
    Question question[];


    //TextView rightAnswer;
    //TextView wrongAnswer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        trueButton = (RadioButton) findViewById(R.id.Truebutton);
        falseButton = (RadioButton) findViewById(R.id.Falsebutton);
        questionText = (TextView) findViewById(R.id.quiz);
        //rightAnswer = (TextView) findViewById(R.id.rightAnswer);
        //wrongAnswer = (TextView)findViewById(R.id.wrongAnswer);

        question1 = new Question("Computer Science is the study of computer",false);
        question2 = new Question("The CPU is responsible for executing instructions for the computer",true);
        question3 = new Question("Each computer has its own machine language which is made of stream of 0s and 1s",true);
        question4 = new Question("Pseudo-code uses exact programming language syntax to represent a module in the larger program", false);
        question5 = new Question("Every program must have exactly one function named main",true);
        Question[] question = new Question[5];
        question[0] = question1;
        question[1] = question2;
        question[2] = question3;
        question[3] = question4;
        question[4] = question5;
        trueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean givenAnswer = true;
                if (givenAnswer == question1.isCorrectAnswer())
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
                if (givenAnswer == question1.isCorrectAnswer())
                {
                    toastMessageID = R.string.right_toast;
                }
                else {
                    toastMessageID = R.string.wrong_toast;
                }
                Toast.makeText(MainActivity.this,toastMessageID,Toast.LENGTH_SHORT).show();
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
