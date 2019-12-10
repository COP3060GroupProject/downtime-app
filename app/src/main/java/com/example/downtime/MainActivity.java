package com.example.downtime;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    CalendarView calendarView;
    TextView date_view;
    Button logout_button;
    FirebaseAuth mFirebaseAuth;
    private FirebaseAuth.AuthStateListener mAuthStateListener;
    androidx.recyclerview.widget.RecyclerView CalEventView;
    com.google.android.material.floatingactionbutton.FloatingActionButton addEvent;
    com.google.android.material.floatingactionbutton.FloatingActionButton leisure;

    List<Events> eventsList = new ArrayList<>(); // create array that will store event fields

//firebase
FirebaseFirestore db = FirebaseFirestore.getInstance();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//---------------------------------------------------
//Sign out
//---------------------------------------------------
        logout_button = (Button)findViewById(R.id.logout_button);

        logout_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                Intent intToMain = new Intent (MainActivity.this, signup.class);
                startActivity(intToMain);

            }
        });

//---------------------------------------------------
//Calendar
//---------------------------------------------------
        calendarView = (CalendarView)
                findViewById(R.id.calendar);
        date_view = (TextView)
                findViewById(R.id.dateView);
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override

            public void onSelectedDayChange(
                    @NonNull CalendarView view,
                    int year,
                    int month,
                    int dayOfMonth)
            {
//create a month array
                String [] Month = { "error", "January","February","March","April","May","June","July","August","September","October","November","December"};
                month = month+1;
                String textMon = " ";
                for(int i = 0; i<13; i++)

                    //if curr month(int) is  equal to the same index in month array
                    textMon =  Month[month];

                String Date = textMon + "  " + dayOfMonth + ", " + year;
                // set this date in TextView for Display
                date_view.setText(Date);
//------------------------------------------------
//Add Event
//------------------------------------------------

                addEvent = (FloatingActionButton)findViewById(R.id.addEvent);
             addEvent.setOnClickListener(new View.OnClickListener(){

                 @Override
                 public void onClick(View v) {
                     Intent i = new Intent ( MainActivity.this,CreateEvent.class);
                     startActivity(i);
                 }
             });
             //---------------------------------
                // click to leisure
                //----------------------------------

               leisure = (FloatingActionButton) findViewById(R.id.leisure);
               leisure.setOnClickListener(new View.OnClickListener() {
                   @Override
                   public void onClick(View v) {
                       Intent  c = new Intent ( MainActivity.this,LeisureDisplay.class);
                       startActivity(c);
                   }
               });
//-------------------------------------------------
//View Event
//-------------------------------------------------
                CalEventView = (RecyclerView)findViewById(R.id.CalEventView);
            }
        });
    }
}