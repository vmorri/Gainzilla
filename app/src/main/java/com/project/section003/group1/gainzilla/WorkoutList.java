package com.project.section003.group1.gainzilla;

import java.util.ArrayList;

public final class WorkoutList {

    // Array that holds a list of workouts
    public static ArrayList<Workout> listworkouts;
    public static int numWorkouts;


    public WorkoutList(){
        listworkouts = new ArrayList<Workout>();
        numWorkouts = listworkouts.size();
    }

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
