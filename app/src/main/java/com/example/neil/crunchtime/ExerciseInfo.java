package com.example.neil.crunchtime;

/**
 * Created by neil on 2/3/16.
 */
public class ExerciseInfo {

    String exercise_name;
    double calories_per; // num calories burned per 1 minute/rep
    Boolean mins_or_reps; //True if mins, False if reps

    public ExerciseInfo() {
        this.exercise_name = "";
        this.calories_per = 0;
        this.mins_or_reps = true;
    }

    public ExerciseInfo(String name, double cals, Boolean measure) {
        this.exercise_name = name;
        this.calories_per = cals;
        this.mins_or_reps = measure;
    }

    public static void main(String[] args) {
        //code here maybe
    }

}