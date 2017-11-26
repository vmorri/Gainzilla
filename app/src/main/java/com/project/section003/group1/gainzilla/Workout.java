package com.project.section003.group1.gainzilla;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;


/*
* Every object of Workout will consist of:
*   - Name of workout
*   - Date it was performed
*   - List of exercises
*   - Amount of rest
*
* WorkoutActivity will be the backend functionality that allows for Workouts to be created
* on the app.
*
* WorkoutList class creates objects that contain a list of workouts. Only one WorkoutList object
* should ever exist.
* */
public class Workout {
    public String name;
    public int Date;
    public ArrayList<Exercise> ex;
    public int rest;
    Intent intent;
    Bundle bundle;
    String pass_exercise_from_exercise;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /** get the intent */
        intent = getIntent();

        /** get the bundle from intent*/
        bundle = intent.getExtras();
        /** retrieve the string extra passed */
        pass_exercise_from_exercise = bundle.getString("exercise_to_pass");

        /** retrieve the stringarray extra passed */
        // String[] arrRecd = b.getStringArray("array");
        // textView.setText(a + ":val:" + arrRecd[1]);
    }

    //Constructor for Workout
    public Workout(String name){
        this.name = name;
    }


    // Adds exercise to workout
    private void addExercise(Exercise exercise){
        this.ex.add(exercise);
    }

    // Deletes exercise in workout
    private void delExercise(int index){
        this.ex.remove(index);
    }

    // The moveUp and moveDown functionality allows the users to change the order
    // of the exercises in the workout.
    private void moveExerciseUp(int index){
        Exercise temp = this.ex.get(index - 1);
        this.ex.set((index - 1), this.ex.get(index));
        this.ex.set(index, temp);
    }

    private void moveExerciseDown(int index){
        Exercise temp = this.ex.get(index + 1);
        this.ex.set((index + 1), this.ex.get(index));
        this.ex.set(index, temp);
    }

    //Saves the workout on to file/database
    private void save(){
        //Add code
    }
}
