package com.example.downtime;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class signup extends AppCompatActivity {
    EditText emailId, password;
    Button btnSignUp;
    TextView tvSignIn;
    FirebaseAuth mFirebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        mFirebaseAuth = FirebaseAuth.getInstance();
        emailId = findViewById(R.id.email);
        password = findViewById(R.id.password);
        btnSignUp = findViewById(R.id.signup_button);
        tvSignIn = findViewById(R.id.signinLink);

        btnSignUp.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String email = emailId.getText().toString();
                String pwd = password.getText().toString();

                if (email.isEmpty()) {
                    emailId.setError("Please enter email.");
                    emailId.requestFocus();
                }
                else if (pwd.isEmpty()) {
                    password.setError("Please enter password.");
                    password.requestFocus();
                }
                else if (email.isEmpty() && pwd.isEmpty()) {
                    Toast.makeText(signup.this, "Fields are empty!", Toast.LENGTH_SHORT).show();
                }
                else if (!(email.isEmpty() && pwd.isEmpty())) {
                    mFirebaseAuth.createUserWithEmailAndPassword(email, pwd).addOnCompleteListener(signup.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (!task.isSuccessful()) {
                                task.getException().printStackTrace();
                                Toast.makeText(signup.this, "Sign up unsuccessful. Please try again.", Toast.LENGTH_SHORT).show();
                            }
                            else {
                                startActivity(new Intent(signup.this, login.class));
                            }
                        }
                    });
                }
                else {
                    Toast.makeText(signup.this, "Error occurred!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        tvSignIn.setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick(View V) {
                Intent i = new Intent (signup.this, login.class);
                startActivity(i);
            }
        });

    }
}