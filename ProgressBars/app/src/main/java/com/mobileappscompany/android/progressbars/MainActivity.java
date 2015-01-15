package com.mobileappscompany.android.progressbars;


import android.app.Activity;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.Toast;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SmilingProgressBar[] progressbars = new SmilingProgressBar[8];
        int[] id_list = {R.id.custEasyView, R.id.custAskNewQuestionView, R.id.custInterviewerMoodView,
            R.id.custTechnicalGuyView, R.id.custWonItView, R.id.custConfidentAboutView,
            R.id.custCallBackView, R.id.custTheySaidView};
        String[] questions_text = getResources().getStringArray(R.array.question_array);
        for(int i = 0; i != id_list.length; ++i){
            progressbars[i] = (SmilingProgressBar) findViewById(id_list[i]);
            progressbars[i].setViewHeader(questions_text[i]);
        }
    }
}