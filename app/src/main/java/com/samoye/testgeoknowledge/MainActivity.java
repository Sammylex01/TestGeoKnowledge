package com.samoye.testgeoknowledge;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.samoye.testgeoknowledge.R;

public class MainActivity extends AppCompatActivity {
    TextView header;
    TextView quest_header1, quest_header2, quest_header3, quest_header4;
    TextView quiz_1, quiz_2, quiz_3, quiz_4;

    RadioGroup rgQuiz1, rgQuiz2, rgQuiz3, rgQuiz4;
    RadioButton radioBtn_istanbul, radioBtn_vatican_city, radioBtn_river_nile, radioBtn_ethiopia, radioBtn_munich, radioBtn_texas, radioBtn_southampton, radioBtn_barcelona, radioBtn_mozambique, radioBtn_egypt, radioBtn_benue, radioBtn_niger;
    Button btnScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radioBtn_istanbul = (RadioButton) findViewById(R.id.radio_istanbul);
        radioBtn_vatican_city = (RadioButton) findViewById(R.id.radio_vatican);
        radioBtn_river_nile = (RadioButton) findViewById(R.id.radio_nile);
        radioBtn_ethiopia = (RadioButton) findViewById(R.id.radio_ethiopia);

        radioBtn_munich = (RadioButton) findViewById(R.id.radio_munich);
        radioBtn_texas = (RadioButton) findViewById(R.id.radio_texas);
        radioBtn_southampton = (RadioButton) findViewById(R.id.radio_southampton);
        radioBtn_barcelona = (RadioButton) findViewById(R.id.radio_barcelona);
        radioBtn_mozambique = (RadioButton) findViewById(R.id.radio_mozambique);
        radioBtn_egypt = (RadioButton) findViewById(R.id.radio_egypt);
        radioBtn_benue = (RadioButton) findViewById(R.id.radio_benue);
        radioBtn_egypt = (RadioButton) findViewById(R.id.radio_niger);

        header = (TextView) findViewById(R.id.header_txt);
        quest_header1 = (TextView) findViewById(R.id.quest1_txt);
        quest_header2 = (TextView) findViewById(R.id.quest2_txt);
        quest_header3 = (TextView) findViewById(R.id.quest3_txt);
        quest_header4 = (TextView) findViewById(R.id.quest4_txt);

        quiz_1 = (TextView) findViewById(R.id.quiz1_txt);
        quiz_2 = (TextView) findViewById(R.id.quiz2_txt);
        quiz_3 = (TextView) findViewById(R.id.quiz3_txt);
        quiz_4 = (TextView) findViewById(R.id.quiz4_txt);

        rgQuiz1 = findViewById(R.id.radio_quiz1);
        rgQuiz2 = findViewById(R.id.radio_quiz2);
        rgQuiz3 = findViewById(R.id.radio_quiz3);
        rgQuiz4 = findViewById(R.id.radio_quiz4);

        btnScore = findViewById(R.id.score_btn);

        btnScore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int radioId1 = rgQuiz1.getCheckedRadioButtonId();
                int radioId2 = rgQuiz2.getCheckedRadioButtonId();
                int radioId3 = rgQuiz3.getCheckedRadioButtonId();
                int radioId4 = rgQuiz4.getCheckedRadioButtonId();

                if (radioId4 == -1) {
                    //
                    Message.message(getApplicationContext(), "Oh! Tough Luck, You didn't attempt to answer any question");
                } else {
                    //
                    findRadioButton(radioId1, radioId2, radioId3);
                }
            }
        });
    }

    private void findRadioButton(int radioId1, int radioId2, int radioId3) {
        switch (radioId1) {
            case R.id.radio_istanbul:
            case R.id.radio_vatican:
            case R.id.radio_nile:
            case R.id.radio_ethiopia:
                Message.message(getApplicationContext(), "You answered the four quizzes correctly, Great Job");
                break;
        }

        switch (radioId2) {
            case R.id.radio_istanbul:
            case R.id.radio_vatican:
            case R.id.radio_nile:
                Message.message(getApplicationContext(), "You only answered three quizzes correctly, Try harder");
                break;
        }

        switch (radioId3) {
            case R.id.radio_istanbul:
            case R.id.radio_vatican:
                Message.message(getApplicationContext(), "You answered two quiz correctly, Add some heat FAM");
                break;
        }

    }
}