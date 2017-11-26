package com.project.section003.group1.gainzilla;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;


/*
*  Provides backend functionality for Workout option from the main page. User will be allowed to
*  create and delete workouts. For current implementation, we only allow the user to have up to
*  7 workouts saved.
* */
public class WorkoutActivity extends AppCompatActivity {
   // public ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Button workoutOne = (Button) findViewById(R.id.workout1);
        Button workoutTwo = (Button) findViewById(R.id.workout2);
        Button workoutThree = (Button) findViewById(R.id.workout3);
        Button workoutFour = (Button) findViewById(R.id.workout4);
        Button workoutFive = (Button) findViewById(R.id.workout5);
        Button workoutSix = (Button) findViewById(R.id.workout6);
        Button workoutSeven = (Button) findViewById(R.id.workout7);

        int WLsize = WorkoutList.numWorkouts;

        if(WLsize == 0){
            workoutOne.setVisibility(View.GONE);
            workoutTwo.setVisibility(View.GONE);
            workoutThree.setVisibility(View.GONE);
            workoutFour.setVisibility(View.GONE);
            workoutFive.setVisibility(View.GONE);
            workoutSix.setVisibility(View.GONE);
            workoutSeven.setVisibility(View.GONE);
        }
        if(WLsize == 1){
            workoutOne.setText(WorkoutList.listworkouts.get(0).name);
            workoutTwo.setVisibility(View.GONE);
            workoutThree.setVisibility(View.GONE);
            workoutFour.setVisibility(View.GONE);
            workoutFive.setVisibility(View.GONE);
            workoutSix.setVisibility(View.GONE);
            workoutSeven.setVisibility(View.GONE);
        }
        if(WLsize == 2){
            workoutOne.setText(WorkoutList.listworkouts.get(0).name);
            workoutTwo.setText(WorkoutList.listworkouts.get(1).name);
            workoutThree.setVisibility(View.GONE);
            workoutFour.setVisibility(View.GONE);
            workoutFive.setVisibility(View.GONE);
            workoutSix.setVisibility(View.GONE);
            workoutSeven.setVisibility(View.GONE);
        }
        if(WLsize == 3) {
            workoutOne.setText(WorkoutList.listworkouts.get(0).name);
            workoutTwo.setText(WorkoutList.listworkouts.get(1).name);
            workoutThree.setText(WorkoutList.listworkouts.get(2).name);
            workoutFour.setVisibility(View.GONE);
            workoutFive.setVisibility(View.GONE);
            workoutSix.setVisibility(View.GONE);
            workoutSeven.setVisibility(View.GONE);
        }
        if(WLsize == 4) {
            workoutOne.setText(WorkoutList.listworkouts.get(0).name);
            workoutTwo.setText(WorkoutList.listworkouts.get(1).name);
            workoutThree.setText(WorkoutList.listworkouts.get(2).name);
            workoutFour.setText(WorkoutList.listworkouts.get(3).name);
            workoutFive.setVisibility(View.GONE);
            workoutSix.setVisibility(View.GONE);
            workoutSeven.setVisibility(View.GONE);
        }
        if(WLsize == 5) {
            workoutOne.setText(WorkoutList.listworkouts.get(0).name);
            workoutTwo.setText(WorkoutList.listworkouts.get(1).name);
            workoutThree.setText(WorkoutList.listworkouts.get(2).name);
            workoutFour.setText(WorkoutList.listworkouts.get(3).name);
            workoutFive.setText(WorkoutList.listworkouts.get(4).name);
            workoutSix.setVisibility(View.GONE);
            workoutSeven.setVisibility(View.GONE);
        }
        if(WLsize == 6) {
            workoutOne.setText(WorkoutList.listworkouts.get(0).name);
            workoutTwo.setText(WorkoutList.listworkouts.get(1).name);
            workoutThree.setText(WorkoutList.listworkouts.get(2).name);
            workoutFour.setText(WorkoutList.listworkouts.get(3).name);
            workoutFive.setText(WorkoutList.listworkouts.get(4).name);
            workoutSix.setText(WorkoutList.listworkouts.get(5).name);
            workoutSeven.setVisibility(View.GONE);
        }
        if(WLsize == 7) {
            workoutOne.setText(WorkoutList.listworkouts.get(0).name);
            workoutTwo.setText(WorkoutList.listworkouts.get(1).name);
            workoutThree.setText(WorkoutList.listworkouts.get(2).name);
            workoutFour.setText(WorkoutList.listworkouts.get(3).name);
            workoutFive.setText(WorkoutList.listworkouts.get(4).name);
            workoutSix.setText(WorkoutList.listworkouts.get(5).name);
            workoutSeven.setText(WorkoutList.listworkouts.get(6).name);
        }
        workoutOne.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                setContentView(R.layout.add);
            }
        });

    }

}
