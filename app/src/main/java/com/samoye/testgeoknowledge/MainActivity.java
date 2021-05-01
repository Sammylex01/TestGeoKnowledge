package com.samoye.testgeoknowledge;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.samoye.testgeoknowledge.R;

import static com.samoye.testgeoknowledge.R.id.countries_answer;
import static com.samoye.testgeoknowledge.R.id.small_countries_answer;
import static com.samoye.testgeoknowledge.R.id.colonize_answer;
import static com.samoye.testgeoknowledge.R.id.river_answer;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<ViewGroup> answersLayouts;

    private int numberOfCorrectAnswers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize and populate the answer
        answersLayouts = populateAnswers();
    }

    /**
     * This method initializes and populates the answerLayouts list.
     *
     * @return The populated List.
     */

    private List<ViewGroup> populateAnswers() {
        List<ViewGroup> answers = new ArrayList<>();

        answers.add((ViewGroup) findViewById(countries_answer));
        answers.add((ViewGroup) findViewById(small_countries_answer));
        answers.add((ViewGroup) findViewById(colonize_answer));
        answers.add((ViewGroup) findViewById(river_answer));

        return answers;
    }

    /**
     * This method communicates the answer layouts and sends each
     * one checkAnswers method for evaluation. It then displays
     * a toast to show the user of their score and resents the
     * answers.
     *
     * @param view was Not used.
     */
    public void gradeQuiz(View view) {
        // Iterate over answerLayouts to check each answer
        for(ViewGroup answers: answersLayouts) {
            checkAnswers(answers);
        }

        // Display results to quiz taker
        String resultsDisplay = "You got " + numberOfCorrectAnswers + " out of " + answersLayouts.size()
                + " questions correct!";

        Toast toast = Toast.makeText(this, resultsDisplay, Toast.LENGTH_LONG);
        toast.show();

        // Reset the answers and number of correct answers
        resetDisplay();
    }

    private void resetDisplay() {
        numberOfCorrectAnswers = 0;

        for (ViewGroup viewGroup: answersLayouts){
            for (int i=0; i < viewGroup.getChildCount(); i++){
                View view = viewGroup.getChildAt(i);
                if (view instanceof RadioButton) {
                    // Cast to RadioButton
                    RadioButton radioButton = ((RadioButton) view);
                    // Clear the group
                    ((RadioGroup)radioButton.getParent()).clearCheck();
                    break; // Not necessary to clear group multiple times
                } else if(view instanceof CheckBox) {
                    ((CheckBox) view).setChecked(false);
                } else if(view instanceof EditText) {
                    ((EditText) view).setText("");
                }
            }
        }
    }


    /**
     * This method checks if the questions have been answered correctly
     *
     */

    private void checkAnswers(ViewGroup answersLayout) {

        int id = answersLayout.getId();

        ViewGroup answers;

        if (id == R.id.countries_answer){
            answers = (ViewGroup) findViewById(R.id.countries_answer);

            EditText answerText = (EditText)answers.getChildAt(0);

            String answer = answerText.getText().toString().trim();

            if(answer.equalsIgnoreCase("istanbul, turkey")) {
                numberOfCorrectAnswers++;
            }

        } else if (id == R.id.small_countries_answer){
            answers = (ViewGroup) findViewById(R.id.small_countries_answer);

            CheckBox vaticanCheckBox = (CheckBox) answers.getChildAt(1);
            CheckBox monacoCheckBox = (CheckBox) answers.getChildAt(2);

            if (!vaticanCheckBox.isChecked() && monacoCheckBox.isChecked()){
                numberOfCorrectAnswers++;
            }

        } else if (id == R.id.colonize_answer){
            answers = (ViewGroup) findViewById(R.id.colonize_answer);

            RadioButton ethiopiaRadioBtn = (RadioButton) answers.getChildAt(2);

            if (ethiopiaRadioBtn.isChecked()){
                numberOfCorrectAnswers++;
            }
        } else if (id == R.id.river_answer){
            answers = (ViewGroup) findViewById(R.id.river_answer);

            RadioButton riverNileRadioBtn = (RadioButton) answers.getChildAt(1);

            if (riverNileRadioBtn.isChecked()){
                numberOfCorrectAnswers++;
            }
        } else {
            // In case an incorrect ViewGroup is passed in
            throw new IllegalArgumentException();
        }
    }
}
