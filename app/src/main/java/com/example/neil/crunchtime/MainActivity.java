package com.example.neil.crunchtime;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    EditText minsLogged;
    TextView calsBurned;
    EditText calsBurnedEdit;
//    Button btnSubmit;
    Spinner exerciseOptions;
    TextView minsOrReps;
    TextView exercise0, conversion0, measure0;
    TextView exercise1, conversion1, measure1;
    TextView exercise2, conversion2, measure2;
    TextView exercise3, conversion3, measure3;
    TextView exercise4, conversion4, measure4;
    TextView exercise5, conversion5, measure5;
    TextView exercise6, conversion6, measure6;
    TextView exercise7, conversion7, measure7;
    TextView exercise8, conversion8, measure8;
    TextView exercise9, conversion9, measure9;
    TextView exercise10, conversion10, measure10;


    float mins, calories;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final HashMap<String, ExerciseInfo> exercise_hash = new HashMap<String, ExerciseInfo>();
        ExerciseInfo cycling = new ExerciseInfo("Cycling", 8.333, true);
        exercise_hash.put("Cycling", cycling);
        ExerciseInfo legLifts = new ExerciseInfo("Leg-Lift", 4, true);
        exercise_hash.put("Leg-Lift", legLifts);
        ExerciseInfo jogging = new ExerciseInfo("Jogging", 8.333, true);
        exercise_hash.put("Jogging", jogging);
        ExerciseInfo jumpingJacks = new ExerciseInfo("Jumping Jacks", 10, true);
        exercise_hash.put("Jumping Jacks", jumpingJacks);
        ExerciseInfo plank = new ExerciseInfo("Plank", 4, true);
        exercise_hash.put("Plank", plank);
        ExerciseInfo pullUps = new ExerciseInfo("Pull Ups", 1, false);
        exercise_hash.put("Pull Ups", pullUps);
        ExerciseInfo pushUps = new ExerciseInfo("Push Ups", .285, false);
        exercise_hash.put("Push Ups", pushUps);
        ExerciseInfo sitUps = new ExerciseInfo("Sit Ups", .5, false);
        exercise_hash.put("Sit Ups", sitUps);
        ExerciseInfo squats = new ExerciseInfo("Squats", .444, false);
        exercise_hash.put("Squats", squats);
        ExerciseInfo stairClimb = new ExerciseInfo("Stair-Climbing", 6.66, true);
        exercise_hash.put("Stair-Climbing", stairClimb);
        ExerciseInfo swimming = new ExerciseInfo("Swimming", 7.692, true);
        exercise_hash.put("Swimming", swimming);
        ExerciseInfo walking = new ExerciseInfo("Walking", 5, true);
        exercise_hash.put("Walking", walking);

        minsLogged = (EditText)findViewById(R.id.editMinsLogged);
        calsBurned = (TextView)findViewById(R.id.viewCalsBurned);
//        calsBurnedEdit = (EditText)findViewById(R.id.viewCalsBurnedEdit);
//        btnSubmit = (Button)findViewById(R.id.submit);
        minsOrReps = (TextView)findViewById(R.id.minsLogged);

        exerciseOptions = (Spinner) findViewById(R.id.excercises);
        ArrayAdapter<CharSequence> exercise_adapter = ArrayAdapter.createFromResource(this,
                R.array.exercises_array, android.R.layout.simple_spinner_item);
        exercise_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        exerciseOptions.setAdapter(exercise_adapter);

        exercise0 = (TextView) findViewById(R.id.e1);
        conversion0 = (TextView) findViewById(R.id.c1);
        measure0 = (TextView) findViewById(R.id.m1);

        exercise1 = (TextView) findViewById(R.id.e2);
        conversion1 = (TextView) findViewById(R.id.c2);
        measure1 = (TextView) findViewById(R.id.m2);

        exercise2 = (TextView) findViewById(R.id.e3);
        conversion2 = (TextView) findViewById(R.id.c3);
        measure2 = (TextView) findViewById(R.id.m3);

        exercise3 = (TextView) findViewById(R.id.e4);
        conversion3 = (TextView) findViewById(R.id.c4);
        measure3 = (TextView) findViewById(R.id.m4);

        exercise4 = (TextView) findViewById(R.id.e5);
        conversion4 = (TextView) findViewById(R.id.c5);
        measure4 = (TextView) findViewById(R.id.m5);

        exercise5 = (TextView) findViewById(R.id.e6);
        conversion5 = (TextView) findViewById(R.id.c6);
        measure5 = (TextView) findViewById(R.id.m6);

        exercise6 = (TextView) findViewById(R.id.e7);
        conversion6 = (TextView) findViewById(R.id.c7);
        measure6 = (TextView) findViewById(R.id.m7);

        exercise7 = (TextView) findViewById(R.id.e8);
        conversion7 = (TextView) findViewById(R.id.c8);
        measure7 = (TextView) findViewById(R.id.m8);

        exercise8 = (TextView) findViewById(R.id.e9);
        conversion8 = (TextView) findViewById(R.id.c9);
        measure8 = (TextView) findViewById(R.id.m9);

        exercise9 = (TextView) findViewById(R.id.e10);
        conversion9 = (TextView) findViewById(R.id.c10);
        measure9 = (TextView) findViewById(R.id.m10);

        exercise10 = (TextView) findViewById(R.id.e11);
        conversion10 = (TextView) findViewById(R.id.c11);
        measure10 = (TextView) findViewById(R.id.m11);

        //Enter code here

        minsLogged.addTextChangedListener(new TextWatcher() {

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String selected_exercise = exerciseOptions.getSelectedItem().toString();
                Log.i("mins Logged:", minsLogged.getText().toString());
                System.out.println(minsLogged.getText().toString());
                calories = 0;
                mins = 0;
                if (minsLogged.getText().length() == 0) {
                    Log.i("", "Got to ZERO");
                    calories = 0;
                    mins = 0;
                } else {
                    mins = Float.parseFloat(minsLogged.getText().toString());

                    if (exercise_hash.get(selected_exercise).mins_or_reps) {
                        minsOrReps.setText("Minutes");
                    } else {
                        minsOrReps.setText("Reps");
                    }
                    calories = Math.round(exercise_hash.get(selected_exercise).calories_per * mins);
                }

                calsBurned.setText(Integer.toString((int) Math.round(calories)));
                calsBurned.setTextColor(Color.BLACK);

//                calsBurnedEdit.setText(Integer.toString((int) Math.round(calories)));

                ArrayList<ExerciseInfo> otherExercises = new ArrayList<ExerciseInfo>();

                for (ExerciseInfo e : exercise_hash.values()) {
                    if (! e.exercise_name.equals(selected_exercise)) {
                        otherExercises.add(e);
//                        exercise1.setText(e.exercise_name);
//                        conversion1.setText(Double.toString((double) Math.round(calories / e.calories_per)));
//                        if(e.mins_or_reps) {
//                            measure1.setText("Minutes");
//                        } else {
//                            measure1.setText("Reps");
//                        }
                    }
                }

                exercise0.setText(otherExercises.get(0).exercise_name);
                conversion0.setText(Integer.toString((int) Math.round(calories / otherExercises.get(0).calories_per)));
                if(otherExercises.get(0).mins_or_reps) {
                    measure0.setText("Minutes");
                } else {
                    measure0.setText("Reps");
                }

                exercise1.setText(otherExercises.get(1).exercise_name);
                conversion1.setText(Integer.toString((int) Math.round(calories / otherExercises.get(1).calories_per)));
                if(otherExercises.get(1).mins_or_reps) {
                    measure1.setText("Minutes");
                } else {
                    measure1.setText("Reps");
                }

                exercise2.setText(otherExercises.get(2).exercise_name);
                conversion2.setText(Integer.toString((int) Math.round(calories / otherExercises.get(2).calories_per)));
                if(otherExercises.get(2).mins_or_reps) {
                    measure2.setText("Minutes");
                } else {
                    measure2.setText("Reps");
                }

                exercise3.setText(otherExercises.get(3).exercise_name);
                conversion3.setText(Integer.toString((int) Math.round(calories / otherExercises.get(3).calories_per)));
                if(otherExercises.get(3).mins_or_reps) {
                    measure3.setText("Minutes");
                } else {
                    measure3.setText("Reps");
                }

                exercise4.setText(otherExercises.get(4).exercise_name);
                conversion4.setText(Integer.toString((int) Math.round(calories / otherExercises.get(4).calories_per)));
                if(otherExercises.get(4).mins_or_reps) {
                    measure4.setText("Minutes");
                } else {
                    measure4.setText("Reps");
                }

                exercise5.setText(otherExercises.get(5).exercise_name);
                conversion5.setText(Integer.toString((int) Math.round(calories / otherExercises.get(5).calories_per)));
                if(otherExercises.get(5).mins_or_reps) {
                    measure5.setText("Minutes");
                } else {
                    measure5.setText("Reps");
                }

                exercise6.setText(otherExercises.get(6).exercise_name);
                conversion6.setText(Integer.toString((int) Math.round(calories / otherExercises.get(6).calories_per)));
                if(otherExercises.get(6).mins_or_reps) {
                    measure6.setText("Minutes");
                } else {
                    measure6.setText("Reps");
                }

                exercise7.setText(otherExercises.get(7).exercise_name);
                conversion7.setText(Integer.toString((int) Math.round(calories / otherExercises.get(7).calories_per)));
                if(otherExercises.get(7).mins_or_reps) {
                    measure7.setText("Minutes");
                } else {
                    measure7.setText("Reps");
                }

                exercise8.setText(otherExercises.get(8).exercise_name);
                conversion8.setText(Integer.toString((int) Math.round(calories / otherExercises.get(8).calories_per)));
                if(otherExercises.get(8).mins_or_reps) {
                    measure8.setText("Minutes");
                } else {
                    measure8.setText("Reps");
                }

                exercise9.setText(otherExercises.get(9).exercise_name);
                conversion9.setText(Integer.toString((int) Math.round(calories / otherExercises.get(9).calories_per)));
                if(otherExercises.get(9).mins_or_reps) {
                    measure9.setText("Minutes");
                } else {
                    measure9.setText("Reps");
                }

                exercise10.setText(otherExercises.get(10).exercise_name);
                conversion10.setText(Integer.toString((int) Math.round(calories / otherExercises.get(10).calories_per)));
                if(otherExercises.get(10).mins_or_reps) {
                    measure10.setText("Minutes");
                } else {
                    measure10.setText("Reps");
                }



            }

            public void afterTextChanged(Editable editable) {

            }

        });


//        calsBurnedEdit.addTextChangedListener(new TextWatcher() {
//
//            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
//
//            }
//
//            @Override
//            public void onTextChanged(CharSequence s, int start, int before, int count) {
//                String selected_exercise = exerciseOptions.getSelectedItem().toString();
//                Log.i("mins Logged:", minsLogged.getText().toString());
//                System.out.println(minsLogged.getText().toString());
//                calories = 0;
//                mins = 0;
//                if (calsBurnedEdit.getText().length() == 0) {
//                    Log.i("", "Got to ZERO");
//                    calories = 0;
//                    mins = 0;
//                } else {
//                    calories = Double.parseDouble(calsBurnedEdit.getText().toString());
//
//                    if (exercise_hash.get(selected_exercise).mins_or_reps) {
//                        minsOrReps.setText("Minutes");
//                    } else {
//                        minsOrReps.setText("Reps");
//                    }
//                    mins = calories / exercise_hash.get(selected_exercise).calories_per;
//                }
//
//                minsLogged.setText(Double.toString((double) Math.round(mins)));
//
//                ArrayList<ExerciseInfo> otherExercises = new ArrayList<ExerciseInfo>();
//
//                for (ExerciseInfo e : exercise_hash.values()) {
//                    if (! e.exercise_name.equals(selected_exercise)) {
//                        otherExercises.add(e);
//                    }
//                }
//
//                exercise0.setText(otherExercises.get(0).exercise_name);
//                conversion0.setText(Double.toString((double) Math.round(calories / otherExercises.get(0).calories_per)));
//                if(otherExercises.get(0).mins_or_reps) {
//                    measure0.setText("Minutes");
//                } else {
//                    measure0.setText("Reps");
//                }
//
//                exercise1.setText(otherExercises.get(1).exercise_name);
//                conversion1.setText(Double.toString((double) Math.round(calories / otherExercises.get(1).calories_per)));
//                if(otherExercises.get(1).mins_or_reps) {
//                    measure1.setText("Minutes");
//                } else {
//                    measure1.setText("Reps");
//                }
//
//                exercise2.setText(otherExercises.get(2).exercise_name);
//                conversion2.setText(Double.toString((double) Math.round(calories / otherExercises.get(2).calories_per)));
//                if(otherExercises.get(2).mins_or_reps) {
//                    measure2.setText("Minutes");
//                } else {
//                    measure2.setText("Reps");
//                }
//
//                exercise3.setText(otherExercises.get(3).exercise_name);
//                conversion3.setText(Double.toString((double) Math.round(calories / otherExercises.get(3).calories_per)));
//                if(otherExercises.get(3).mins_or_reps) {
//                    measure3.setText("Minutes");
//                } else {
//                    measure3.setText("Reps");
//                }
//
//                exercise4.setText(otherExercises.get(4).exercise_name);
//                conversion4.setText(Double.toString((double) Math.round(calories / otherExercises.get(4).calories_per)));
//                if(otherExercises.get(4).mins_or_reps) {
//                    measure4.setText("Minutes");
//                } else {
//                    measure4.setText("Reps");
//                }
//
//                exercise5.setText(otherExercises.get(5).exercise_name);
//                conversion5.setText(Double.toString((double) Math.round(calories / otherExercises.get(5).calories_per)));
//                if(otherExercises.get(5).mins_or_reps) {
//                    measure5.setText("Minutes");
//                } else {
//                    measure5.setText("Reps");
//                }
//
//                exercise6.setText(otherExercises.get(6).exercise_name);
//                conversion6.setText(Double.toString((double) Math.round(calories / otherExercises.get(6).calories_per)));
//                if(otherExercises.get(6).mins_or_reps) {
//                    measure6.setText("Minutes");
//                } else {
//                    measure6.setText("Reps");
//                }
//
//                exercise7.setText(otherExercises.get(7).exercise_name);
//                conversion7.setText(Double.toString((double) Math.round(calories / otherExercises.get(7).calories_per)));
//                if(otherExercises.get(7).mins_or_reps) {
//                    measure7.setText("Minutes");
//                } else {
//                    measure7.setText("Reps");
//                }
//
//                exercise8.setText(otherExercises.get(8).exercise_name);
//                conversion8.setText(Double.toString((double) Math.round(calories / otherExercises.get(8).calories_per)));
//                if(otherExercises.get(8).mins_or_reps) {
//                    measure8.setText("Minutes");
//                } else {
//                    measure8.setText("Reps");
//                }
//
//                exercise9.setText(otherExercises.get(9).exercise_name);
//                conversion9.setText(Double.toString((double) Math.round(calories / otherExercises.get(9).calories_per)));
//                if(otherExercises.get(9).mins_or_reps) {
//                    measure9.setText("Minutes");
//                } else {
//                    measure9.setText("Reps");
//                }
//
//                exercise10.setText(otherExercises.get(10).exercise_name);
//                conversion10.setText(Double.toString((double) Math.round(calories / otherExercises.get(10).calories_per)));
//                if(otherExercises.get(10).mins_or_reps) {
//                    measure10.setText("Minutes");
//                } else {
//                    measure10.setText("Reps");
//                }
//
//
//
//            }
//
//            public void afterTextChanged(Editable editable) {
//
//            }
//
//        });




//        btnSubmit.setOnClickListener(new View.OnClickListener() {
//
//            public void onClick(View v) {
//                String selected_exercise = exerciseOptions.getSelectedItem().toString();
//                Log.i("mins Logged:", minsLogged.getText().toString());
//                System.out.println(minsLogged.getText().toString());
//                calories = 0;
//                mins = 0;
//                if (minsLogged.getText().length() == 0) {
//                    Log.i("", "Got to ZERO");
//                    calories = (double) 0;
//                    mins = 0;
//                } else {
//                    mins = Double.parseDouble(minsLogged.getText().toString());
//
//                    if (exercise_hash.get(selected_exercise).mins_or_reps) {
//                        minsOrReps.setText("Minutes");
//                    } else {
//                        minsOrReps.setText("Reps");
//                    }
//                    calories = exercise_hash.get(selected_exercise).calories_per * mins;
//                }
//
//                calsBurned.setText(Double.toString(calories));
//                calsBurned.setTextColor(Color.BLACK);
//
//            }
//
//        });



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
