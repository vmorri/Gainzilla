package com.project.section003.group1.gainzilla;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

public class WorkoutActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.project.section003.group1.gainzilla";

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
                Intent intent = new Intent(view.getContext(), WorkoutDisplayActivity.class);
                String message = "1";
                intent.putExtra(EXTRA_MESSAGE, message);
                startActivity(intent);
            }
        });
        workoutTwo.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), WorkoutDisplayActivity.class);
                String message = "2";
                intent.putExtra(EXTRA_MESSAGE, message);
                startActivity(intent);
            }
        });
        workoutThree.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), WorkoutDisplayActivity.class);
                String message = "3";
                intent.putExtra(EXTRA_MESSAGE, message);
                startActivity(intent);
            }
        });
        workoutFour.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), WorkoutDisplayActivity.class);
                String message = "4";
                intent.putExtra(EXTRA_MESSAGE, message);
                startActivity(intent);
            }
        });
        workoutFive.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), WorkoutDisplayActivity.class);
                String message = "5";
                intent.putExtra(EXTRA_MESSAGE, message);
                startActivity(intent);
            }
        });
        workoutSix.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), WorkoutDisplayActivity.class);
                String message = "6";
                intent.putExtra(EXTRA_MESSAGE, message);
                startActivity(intent);
            }
        });
        workoutSeven.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), WorkoutDisplayActivity.class);
                String message = "7";
                intent.putExtra(EXTRA_MESSAGE, message);
                startActivity(intent);
            }
        });
    }

}
