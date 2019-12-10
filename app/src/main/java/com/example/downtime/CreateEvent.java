package com.example.downtime;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;


public class CreateEvent extends AppCompatActivity {

   EditText eventLocation, eventDuration, eventDescription, eventName;
   Button createButton;
   FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_event);


eventLocation = (EditText)findViewById(R.id.eventLocation);
eventDuration = (EditText)findViewById(R.id.eventDuration);
eventDescription = (EditText)findViewById(R.id.eventDescription);
eventName = (EditText)findViewById(R.id.eventDescrib);

db = FirebaseFirestore.getInstance();


createButton = (Button)findViewById(R.id.createButton);
createButton.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        // Create a new user with a first and last name
        Map<String, Object> event = new HashMap<>();
        event.put("name", eventName.getText().toString());
        event.put("description", eventDescription.getText().toString());
        event.put("duration", Integer.valueOf(eventDuration.getText().toString()));
        event.put("location", eventLocation.getText().toString());

// Add a new document with a generated ID
        db.collection("events")
                .add(event)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        //Log.d(TAG, "DocumentSnapshot added with ID: " + documentReference.getId());
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {

                        Toast.makeText(CreateEvent.this, "Event Created!", Toast.LENGTH_SHORT).show();
                        Intent c = new Intent ( CreateEvent.this,MainActivity.class);
                        startActivity(c);


                    }
                });

    }
});
    }






















/*
    public void create(View v ) {
        Events events = new Events (eventName.getText().toString(),eventDescription.getText().toString(),
                                    eventLocation.getText().toString(),Integer.valueOf(eventDuration.getText().toString()));

        db.collection("NewEvent").document("2").set(events)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(getApplicationContext(),"Data stored successfully", Toast.LENGTH_LONG).show();
                        }
                        else {
                            Toast.makeText(getApplicationContext(),"Error", Toast.LENGTH_LONG).show();
                          //  Toast.makeText(getApplicationContext(),task.getException().getMessage(),Toast.LENGTH_LONG).show();
                        }

                    }
                });

    }
 */




}
