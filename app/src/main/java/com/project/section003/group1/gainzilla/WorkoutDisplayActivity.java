package com.project.section003.group1.gainzilla;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class WorkoutDisplayActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout_display);

        Intent intent = getIntent();
        String message = intent.getStringExtra(WorkoutActivity.EXTRA_MESSAGE);
        int workoutNum = Integer.parseInt(message);


    }

}
