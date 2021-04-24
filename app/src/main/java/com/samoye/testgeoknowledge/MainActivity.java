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
    Button btnScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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

//        btnScore.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                int checkId1 = rgQuiz1.getCheckedRadioButtonId();
//                if (checkId1 == -1){
//                    // No radio buttons are checked
//                    message(getApplicationContext(), "Kindly select an option");
//                }else{
//                    //One of the radio button is checked
//                    findRadioButton(checkId1);
//                }
//                int checkId2 = rgQuiz2.getCheckedRadioButtonId();
//                int checkId3 = rgQuiz3.getCheckedRadioButtonId();
//                int checkId4 = rgQuiz4.getCheckedRadioButtonId();
//
//
//
//            }
//        });

    }

//    private void findRadioButton(int checkId1) {
//        switch (checkId1){
//            case R.id.radio_istanbul
//        }
//    }

    public static void message(Context context, String msg){
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
    }

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
//        boolean checked = ((RadioButton) view).isChecked();
//
//        //Check which radio button was clicked
//        switch (view.getId()) {
//            case R.id.radio_istanbul:
//                if (checked)
//                    break;
//            case R.id.radio_munich:
//                if (checked)
//                    break;
//            case R.id.radio_texas:
//                if (checked)
//                    break;
//        }
    }


    /**
     * This method is called when the order button is clicked
     */
    public void submitQuiz(View view){
        RadioButton radioBtn_istanbul = (RadioButton) findViewById(R.id.radio_istanbul);
        RadioButton radioBtn_vatican_city = (RadioButton) findViewById(R.id.radio_vatican);
        RadioButton radioBtn_river_nile = (RadioButton) findViewById(R.id.radio_nile);
        RadioButton radioBtn_ethopia = (RadioButton) findViewById(R.id.radio_ethiopia);

        //Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        if (radioBtn_istanbul.isChecked() && radioBtn_vatican_city.isChecked() && radioBtn_river_nile.isChecked() && radioBtn_ethopia.isChecked()){
            Toast.makeText(this, "You answered the three quizzes correctly, Great Job", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(this, "You only answered zero to two quizzes correctly, Try harder", Toast.LENGTH_SHORT).show();
        }
    }
}