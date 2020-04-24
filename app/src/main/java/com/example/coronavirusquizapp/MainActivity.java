package com.example.coronavirusquizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int correctAnswers = 0;
    EditText name;
    EditText state;
    RadioButton answer_2_question_1;
    RadioButton answer_1_question_2;
    RadioButton answer_2_question_3;
    RadioButton answer_2_question_4;
    RadioButton answer_3_question_6;
    CheckBox answer_1_question_7;
    CheckBox answer_2_question_7;
    CheckBox answer_3_question_7;
    CheckBox answer_4_question_7;
    CheckBox answer_5_question_7;
    RadioButton answer_4_question_8;
    RadioButton answer_2_question_9;
    CheckBox answer_1_question_10;
    CheckBox answer_2_question_10;
    CheckBox answer_3_question_10;
    CheckBox answer_4_question_10;
    Boolean Question1Correct;
    Boolean Question2Correct;
    Boolean Question3Correct;
    Boolean Question4Correct;
    Boolean Question5Correct;
    Boolean Question6Correct;
    Boolean Question7Correct;
    Boolean Question8Correct;
    Boolean Question9Correct;
    Boolean Question10Correct;
    String finalToast1;
    String finalToast2;
    String questionsWrong;
    String greeting;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText name = (EditText) findViewById(R.id.name_input);
        EditText state = (EditText) findViewById(R.id.rhode_island_ban_question_5);
    }

    //Check which Radio Buttons have an have not been checked, and passes that information over to be calculated
    public void answerCheck(View view){
        boolean choiceForStateBan;

        name =(EditText) findViewById(R.id.name_input);
        String usersName = name.getText().toString();

        state = (EditText) findViewById(R.id.rhode_island_ban_question_5);
        String stateBanned = state.getText().toString();

        boolean stateBanned1 =stateBanned.equalsIgnoreCase("New York");

        //checks if the user entered "New York", the correct answer for the question
        if(stateBanned1 == true){
            choiceForStateBan = new Boolean(true);
        }

        else{
            choiceForStateBan = new Boolean(false);
        }

        //Checks whether or not the correct Radio Buttons/Checkboxes has been selected for each question
        answer_2_question_1 = (RadioButton) findViewById(R.id.answer_2_question_1);
        boolean choiceForQuestion1 = answer_2_question_1.isChecked();

        answer_1_question_2 = (RadioButton) findViewById(R.id.answer_1_question_2);
        boolean choiceForQuestion2 = answer_1_question_2.isChecked();

        answer_2_question_3 = (RadioButton) findViewById(R.id.answer_2_question_3);
        boolean choiceForQuestion3 = answer_2_question_3.isChecked();

        answer_2_question_4 = (RadioButton) findViewById(R.id.answer_2_question_4);
        boolean choiceForQuestion4 = answer_2_question_4.isChecked();

        answer_3_question_6 = (RadioButton) findViewById(R.id.answer_3_question_6);
        boolean choiceForQuestion6 = answer_3_question_6.isChecked();

        answer_1_question_7 = (CheckBox) findViewById(R.id.answer_1_question_7);
        boolean checkedOrNotChoice1Q7 = answer_1_question_7.isChecked();

        answer_2_question_7 = (CheckBox) findViewById(R.id.answer_2_question_7);
        boolean checkedOrNotChoice2Q7 = answer_2_question_7.isChecked();

        answer_3_question_7 = (CheckBox) findViewById(R.id.answer_3_question_7);
        boolean checkedOrNotChoice3Q7 = answer_3_question_7.isChecked();

        answer_4_question_7 = (CheckBox) findViewById(R.id.answer_4_question_7);
        boolean checkedOrNotChoice4Q7 = answer_4_question_7.isChecked();

        answer_5_question_7 = (CheckBox) findViewById(R.id.answer_5_question_7);
        boolean checkedOrNotChoice5Q7 = answer_5_question_7.isChecked();

        answer_4_question_8 = (RadioButton) findViewById(R.id.answer_4_question_8);
        boolean choiceForQuestion8 = answer_4_question_8.isChecked();

        answer_2_question_9 = (RadioButton) findViewById(R.id.answer_2_question_9);
        boolean choiceForQuestion9 = answer_2_question_9.isChecked();

        answer_1_question_10 = (CheckBox) findViewById(R.id.answer_1_question_10);
        boolean checkedOrNotChoice1Q10 = answer_1_question_10.isChecked();

        answer_2_question_10 = (CheckBox) findViewById(R.id.answer_2_question_10);
        boolean checkedOrNotChoice2Q10 = answer_2_question_10.isChecked();

        answer_3_question_10 = (CheckBox) findViewById(R.id.answer_3_question_10);
        boolean checkedOrNotChoice3Q10 = answer_3_question_10.isChecked();

        answer_4_question_10 = (CheckBox) findViewById(R.id.answer_4_question_10);
        boolean checkedOrNotChoice4Q10 = answer_4_question_10.isChecked();

        correctAnswers = scoreCalculated(choiceForQuestion1, choiceForQuestion2, choiceForQuestion3, choiceForQuestion4, choiceForStateBan, choiceForQuestion6, checkedOrNotChoice1Q7, checkedOrNotChoice2Q7, checkedOrNotChoice3Q7, checkedOrNotChoice4Q7, checkedOrNotChoice5Q7, choiceForQuestion8,  choiceForQuestion9, checkedOrNotChoice1Q10, checkedOrNotChoice2Q10, checkedOrNotChoice3Q10, checkedOrNotChoice4Q10);

        //Changes the greeting to appropriately match the score
        if (correctAnswers >= 8){
            greeting = "Congrats, " + usersName + "!";
        }

        if (correctAnswers < 8 && correctAnswers >= 4){
            greeting = "Nice try, " + usersName + ".";
        }

        else {
            greeting = "Unfortunately, " + usersName + ".";
        }

        finalToast1 = greeting + " Your score is " + correctAnswers + " out of 10 possible points!";
        finalToast2 = "\nRemember to stay safe and healthy, spread this quiz to help keep people safe!";

        //Adds feedback for incorrect answers to final string

        //If all questions are correct
        if (Question1Correct == true && Question2Correct == true && Question3Correct == true && Question4Correct == true && Question5Correct == true && Question6Correct == true && Question7Correct == true && Question8Correct == true && Question9Correct == true && Question10Correct == true) {
            finalToast1 = finalToast1 + " You got a perfect score! Nice work!";
        }

        //When one or more questions are wrong
        else{

            questionsWrong = "";

            if (Question1Correct == false) {
                questionsWrong = questionsWrong + ", 1";
            }

            if (Question2Correct == false) {
                questionsWrong = questionsWrong + ", 2";
            }

            if (Question3Correct == false) {
                questionsWrong = questionsWrong + ", 3";
            }

            if (Question4Correct == false) {
                questionsWrong = questionsWrong + ", 4";
            }

            if (Question5Correct == false) {
                questionsWrong = questionsWrong + ", 5";
            }

            if (Question6Correct == false) {
                questionsWrong = questionsWrong + ", 6";
            }

            if (Question7Correct == false) {
                questionsWrong = questionsWrong + ", 7";
            }

            if (Question8Correct == false) {
                questionsWrong = questionsWrong + ", 8";
            }

            if (Question9Correct == false) {
                questionsWrong = questionsWrong + ", 9";
            }

            if (Question10Correct == false) {
                questionsWrong = questionsWrong + ", 10";
            }

            //Deletes the first occurrence of a comma and space to remove the extra whitespace from the questionsWrong string
            questionsWrong = questionsWrong.replaceFirst(", ", " ");

            finalToast1 = finalToast1 + " However question(s)" + questionsWrong + " were incorrect.";

        }

        //Toast message that is displayed once the user has completed the quiz
        Toast toast = Toast.makeText(getApplicationContext(), finalToast1 + finalToast2, Toast.LENGTH_LONG);
        toast.show();

    }

    //Calculates the amount of correct answers inputted
    public int scoreCalculated(boolean choiceForQuestion1, boolean choiceForQuestion2, boolean choiceForQuestion3, boolean choiceForQuestion4, boolean choiceForStateBan, boolean choiceForQuestion6, boolean checkedOrNotChoice1Q7, boolean checkedOrNotChoice2Q7, boolean checkedOrNotChoice3Q7, boolean checkedOrNotChoice4Q7, boolean checkedOrNotChoice5Q7, boolean choiceForQuestion8, boolean choiceForQuestion9, boolean checkedOrNotChoice1Q10, boolean checkedOrNotChoice2Q10, boolean checkedOrNotChoice3Q10, boolean checkedOrNotChoice4Q10) {
        int answersCorrect = 0;

        if (choiceForQuestion1 == true) {
            answersCorrect += 1;
            Question1Correct = true;
        }

        else {
            Question1Correct = false;
        }

        if (choiceForQuestion2 == true) {
            answersCorrect += 1;
            Question2Correct = true;
        }

        else {
            Question2Correct = false;
        }

        if (choiceForQuestion3 == true) {
            answersCorrect += 1;
            Question3Correct = true;
        }

        else {
            Question3Correct = false;
        }

        if (choiceForQuestion4 == true) {
            answersCorrect += 1;
            Question4Correct = true;
        }

        else {
            Question4Correct = false;
        }

        if (choiceForStateBan == true) {
            answersCorrect += 1;
            Question5Correct = true;
        }

        else {
            Question5Correct = false;
        }

        if (choiceForQuestion6 == true) {
            answersCorrect += 1;
            Question6Correct = true;
        }

        else {
            Question6Correct = false;
        }

        if (checkedOrNotChoice1Q7 == false && checkedOrNotChoice2Q7 == false && checkedOrNotChoice3Q7 == false && checkedOrNotChoice4Q7 == false && checkedOrNotChoice5Q7 == true) {
            answersCorrect += 1;
            Question7Correct = true;
        }

        else {
            Question7Correct = false;
        }

        if (choiceForQuestion8 == true) {
            answersCorrect += 1;
            Question8Correct = true;
        }

        else {
            Question8Correct = false;
        }

        if (choiceForQuestion9 == true) {
            answersCorrect += 1;
            Question9Correct = true;
        }

        else {
            Question9Correct = false;
        }

        if (checkedOrNotChoice1Q10 == false && checkedOrNotChoice2Q10 == true && checkedOrNotChoice3Q10 == false && checkedOrNotChoice4Q10 == true) {
            answersCorrect += 1;
            Question10Correct = true;
        }

        else {
            Question10Correct = false;
        }

        return answersCorrect;
    }

    public void onRadioButtonInQ1Clicked(View view) {

        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.answer_1_question_1:
                if (checked)

                    break;
            case R.id.answer_2_question_1:
                if (checked)

                    break;
            case R.id.answer_3_question_1:
                if (checked)

                    break;

            case R.id.answer_4_question_1:
                if (checked)

                    break;

        }
    }

    public void onRadioButtonInQ2Clicked(View view) {

        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.answer_1_question_2:
                if (checked)

                    break;
            case R.id.answer_2_question_2:
                if (checked)

                    break;
            case R.id.answer_3_question_2:
                if (checked)

                    break;

            case R.id.answer_4_question_2:
                if (checked)

                    break;

        }
    }

    public void onRadioButtonInQ3Clicked(View view) {

        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.answer_1_question_3:
                if (checked)

                    break;
            case R.id.answer_2_question_3:
                if (checked)

                    break;
            case R.id.answer_3_question_3:
                if (checked)

                    break;

            case R.id.answer_4_question_3:
                if (checked)

                    break;

        }
    }

    public void onRadioButtonInQ4Clicked(View view) {

        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.answer_1_question_4:
                if (checked)

                    break;
            case R.id.answer_2_question_4:
                if (checked)

                    break;

        }
    }

    public void onRadioButtonInQ6Clicked(View view) {

        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.answer_1_question_6:
                if (checked)

                    break;
            case R.id.answer_2_question_6:
                if (checked)

                    break;
            case R.id.answer_3_question_6:
                if (checked)

                    break;

            case R.id.answer_4_question_6:
                if (checked)

                    break;

        }
    }

    public void onRadioButtonInQ8Clicked(View view) {

        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.answer_1_question_8:
                if (checked)

                    break;
            case R.id.answer_2_question_8:
                if (checked)

                    break;
            case R.id.answer_3_question_8:
                if (checked)

                    break;

            case R.id.answer_4_question_8:
                if (checked)

                    break;

        }
    }

    public void onRadioButtonInQ9Clicked(View view) {

        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.answer_1_question_9:
                if (checked)

                    break;
            case R.id.answer_2_question_9:
                if (checked)

                    break;
            case R.id.answer_3_question_9:
                if (checked)

                    break;

            case R.id.answer_4_question_9:
                if (checked)

                    break;

        }
    }

    //Resets the Quiz by removing all checks and text
    public void resetTheQuiz(View view) {

        if (name != null)
            name.setText("");
        else {
            name = (EditText) findViewById(R.id.name_input);
            name.setText("");
        }

        if (state != null)
            state.setText("");
        else {
            state = (EditText) findViewById(R.id.rhode_island_ban_question_5);
            state.setText("");
        }

        if (answer_1_question_7 != null)
            answer_1_question_7.setChecked(false);
        else {
            answer_1_question_7 = (CheckBox) findViewById(R.id.answer_1_question_7);
            answer_1_question_7.setChecked(false);
        }

        if (answer_2_question_7 != null)
            answer_2_question_7.setChecked(false);
        else {
            answer_2_question_7 = (CheckBox) findViewById(R.id.answer_2_question_7);
            answer_2_question_7.setChecked(false);
        }


        if (answer_3_question_7 != null)
            answer_3_question_7.setChecked(false);
        else {
            answer_3_question_7 = (CheckBox) findViewById(R.id.answer_3_question_7);
            answer_3_question_7.setChecked(false);
        }


        if (answer_4_question_7 != null)
            answer_4_question_7.setChecked(false);
        else {
            answer_4_question_7 = (CheckBox) findViewById(R.id.answer_4_question_7);
            answer_4_question_7.setChecked(false);
        }

        if (answer_5_question_7 != null)
            answer_5_question_7.setChecked(false);
        else {
            answer_5_question_7 = (CheckBox) findViewById(R.id.answer_5_question_7);
            answer_5_question_7.setChecked(false);
        }

        if (answer_1_question_10 != null)
            answer_1_question_10.setChecked(false);
        else {
            answer_1_question_10 = (CheckBox) findViewById(R.id.answer_1_question_10);
            answer_1_question_10.setChecked(false);
        }

        if (answer_2_question_10 != null)
            answer_2_question_10.setChecked(false);
        else {
            answer_2_question_10 = (CheckBox) findViewById(R.id.answer_2_question_10);
            answer_2_question_10.setChecked(false);
        }

        if (answer_3_question_10 != null)
            answer_3_question_10.setChecked(false);
        else {
            answer_3_question_10 = (CheckBox) findViewById(R.id.answer_3_question_10);
            answer_3_question_10.setChecked(false);
        }

        if (answer_4_question_10 != null)
            answer_4_question_10.setChecked(false);
        else {
            answer_4_question_10 = (CheckBox) findViewById(R.id.answer_4_question_10);
            answer_4_question_10.setChecked(false);
        }

        questionsWrong = "";

        greeting = "";

        RadioGroup radioGroupForQuestion1 = (RadioGroup) findViewById(R.id.choices_For_Question1);
        radioGroupForQuestion1.clearCheck();

        RadioGroup radioGroupForQuestion2 = (RadioGroup) findViewById(R.id.choices_For_Question2);
        radioGroupForQuestion2.clearCheck();

        RadioGroup radioGroupForQuestion3 = (RadioGroup) findViewById(R.id.choices_For_Question3);
        radioGroupForQuestion3.clearCheck();

        RadioGroup radioGroupForQuestion4 = (RadioGroup) findViewById(R.id.choices_For_Question4);
        radioGroupForQuestion4.clearCheck();

        RadioGroup radioGroupForQuestion6 = (RadioGroup) findViewById(R.id.choices_For_Question6);
        radioGroupForQuestion6.clearCheck();

        RadioGroup radioGroupForQuestion8 = (RadioGroup) findViewById(R.id.choices_For_Question8);
        radioGroupForQuestion8.clearCheck();

        RadioGroup radioGroupForQuestion9 = (RadioGroup) findViewById(R.id.choices_For_Question9);
        radioGroupForQuestion9.clearCheck();

        Toast toast = Toast.makeText(getApplicationContext(), "Quiz Reset!", Toast.LENGTH_LONG);
        toast.show();


    }

}
