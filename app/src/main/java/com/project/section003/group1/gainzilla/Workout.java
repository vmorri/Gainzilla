package com.project.section003.group1.gainzilla;

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
public class Workout{
    public String name;
    public int Date;
    public ArrayList<Exercise> ex;
    public int rest;

    //Constructor for Workout
    public Workout(){
        this.name = "Unknown";
    }

    public void changeName(String name){
        this.name = name;
    }


    // Adds exercise to workout
    public void addExercise(Exercise exercise){
        this.ex.add(exercise);
    }

    // Deletes exercise in workout
    public void delExercise(int index){
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
