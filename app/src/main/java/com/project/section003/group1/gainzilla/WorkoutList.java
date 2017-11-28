package com.project.section003.group1.gainzilla;

import java.io.Serializable;
import java.util.ArrayList;

public final class WorkoutList implements Serializable{

    // Array that holds a list of workouts
    public static ArrayList<Workout> listworkouts;

    //Creates the workout list
    public WorkoutList(){
        this.listworkouts = new ArrayList<Workout>();
    }

    //Returns the workout
    public ArrayList<Workout> getWorkoutList(){
        return this.listworkouts;
    }

    /*
    public void addNewWorkout(Workout plan){

        // If plan does not match with any of workouts, allow to add
        // Otherwise return an error
        for(Workout w: listworkouts){
            if(w.name.equals(plan.name)){
                System.out.println("Plan is already inside list");
                break;
            }

            else{
                listworkouts.add(plan);
            }
        }
    }
    */

    public void deleteWorkout(Workout plan){

        // If plan does not match with any of workouts, allow to add
        // Otherwise return an error
        for(Workout w: listworkouts){
            if(w.name.equals(plan.name)){
                listworkouts.remove(plan);
                break;
            }

            else{
                System.out.println("The plan does not exist!");
            }
        }
    }


    //ArrayList<Workout> workouts;
    //Workout currentWorkout;
}
