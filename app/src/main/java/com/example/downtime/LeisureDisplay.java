package com.example.downtime;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class LeisureDisplay extends AppCompatActivity {

    int totEvents, LeisureTime;
    EditText displayLeisureTime;
    Button calculate;
    TextView finalLeisure, totalEvents;
    FirebaseFirestore db;

int duration;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leisure_display);

        totalEvents = (TextView) findViewById(R.id.tvEvents);
        finalLeisure = (TextView)findViewById(R.id.tvLeisure);

        calculate = (Button) findViewById(R.id.calculateLeisureTime);
        calculate.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
//int duration = calculateDuration();
int sleepHrs = 7;
int leisure = 0;

db = FirebaseFirestore.getInstance();
int total = 0;
                final HashMap<String, Object> holder = new HashMap<String, Object>();

                String s;
                final int[] count = {0};

                db.collection("events")
                        .whereGreaterThan("duration", 0)
                        .get()
                        .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                            @Override
                            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                                if (task.isSuccessful()) {
                                    for (QueryDocumentSnapshot document : task.getResult()) {
                                        holder.put(document.getId(), document.getData());
                                        count[0]++;


                                        Intent c = new Intent ( LeisureDisplay.this,MainActivity.class);
                                        startActivity(c);
                                    }
                                }
                            }
                        });

                // Returns Set view
                Set< Map.Entry< String,Object> > st = holder.entrySet();

                for (Map.Entry< String,Object> me:st)
                {
                    s = me.getValue().toString();
                    int result = Integer.parseInt(s);
                    total += result;

                }
                leisure = 24 - (total + sleepHrs);

                String result = Integer.toString(leisure);
                String counter = Integer.toString(count[0]);

                finalLeisure.setText(result);
                totalEvents.setText(counter);

            }
        });

    }
}