package com.project.section003.group1.gainzilla;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;

public class Workout extends AppCompatActivity {
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

    public Workout(String name){
        this.name = name;
    }

    private void addExercise(Exercise exercise){
        this.ex.add(exercise);
    }

    private void delExercise(int index){
        this.ex.remove(index);
    }
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

    private void save(){

    }


}
