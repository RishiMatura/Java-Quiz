package com.example.javaquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
private  String[] questions = {"Was Java introduced in 1920?","Number of primitive data types in Java are 8?", "Does Java support OOPs?", "Is Java developed by Elon Musk?",
"Does Java support abstract classes?"};
private  boolean[] answers = {false, true, true, false, true};
Button yes;
Button no;
Button restart;
private int index=0;
private int score=0;
private int count =1;
//public static boolean booleanVar = false; //To make this toast "Press restart to take the quiz again" appear only once

TextView question;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        yes = findViewById(R.id.yes);
        no = findViewById(R.id.no);
        question = findViewById(R.id.question);
        restart = findViewById(R.id.restart);
        question.setText("Q"+count + "  "+questions[index]);

        yes.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                if(index<=questions.length-1)
                {
                    if(answers[index]) {
                        score++;
                    }
                    index++;
                    count++;
                    if(index<=questions.length-1) {
                        question.setText("Q"+count + "  "+questions[index]);
                    }
                    else
                    {
                        Toast.makeText(MainActivity.this, "Your Score is "+score+ "/" +questions.length, Toast.LENGTH_SHORT).show();
                    }
                }
                else {
//                    if(!booleanVar)  //To make this toast appear only once
//                    {
                        Toast.makeText(MainActivity.this, "Press Restart to take the quiz again", Toast.LENGTH_SHORT).show();
//                        booleanVar=true;  / /To make this toast appear only once
//                    }
                }

            }
        });

        no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(index<=questions.length-1)
                {
                    if(!answers[index]) {
                        ++score;
                    }
                    ++index;
                    count++;
                    if(index<=questions.length-1){
                        question.setText("Q"+count + "  "+questions[index]);
                    }
                    else
                    {
                        Toast.makeText(MainActivity.this, "Your Score is "+score+ "/" +questions.length, Toast.LENGTH_SHORT).show();
                    }
                }
                else {
//                    if(!booleanVar) //To make this toast appear only once
//                    {
                        Toast.makeText(MainActivity.this, "Press Restart to take the quiz again", Toast.LENGTH_SHORT).show();
//                        booleanVar=true;   //To make this toast appear only once
//                    }
                }
            }
        });

        restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                index=0;
                count=1;
                score=0;
                question.setText("Q"+count + "  "+questions[index]);
//                booleanVar=false;   //To make this toast "Press restart to take the quiz again" appear only once
            }
        });
    }
}