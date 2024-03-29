package com.example.downtime;
//change login to the main event page
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
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
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;

public class login extends AppCompatActivity {

    EditText emailId, password;
    Button btnSignIn;
    TextView tvSignUp;
    FirebaseAuth mFirebaseAuth;
    private FirebaseAuth.AuthStateListener mAuthStateListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mFirebaseAuth = FirebaseAuth.getInstance();
        emailId = findViewById(R.id.username);
        password = findViewById(R.id.password);
        btnSignIn = findViewById(R.id.loginButton);
        tvSignUp = findViewById(R.id.slink);

        mAuthStateListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser mFirebaseUser = mFirebaseAuth.getCurrentUser();
                if(mFirebaseUser != null) {
                    Toast.makeText(login.this, "You are logged in.", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent (login.this, MainActivity.class);
                    startActivity(i);
                }
                else {
                    Toast.makeText(login.this, "Please log in.", Toast.LENGTH_SHORT).show();
                }
            }
        };

        btnSignIn.setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick(View V) {
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
                    Toast.makeText(login.this, "Fields are empty!", Toast.LENGTH_SHORT).show();
                }
                else if (!(email.isEmpty() && pwd.isEmpty())) {
                    mFirebaseAuth.signInWithEmailAndPassword(email, pwd).addOnCompleteListener(login.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(!task.isSuccessful()) {
                                Toast.makeText(login.this, "Log in error, please log in again.", Toast.LENGTH_SHORT).show();
                            }
                            else {
                                Intent intToHome = new Intent (login.this, MainActivity.class);
                                startActivity(intToHome);
                            }
                        }
                    });
                }
                else {
                    Toast.makeText(login.this, "Error occurred!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        tvSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intSignUp = new Intent (login.this, signup.class);
                startActivity(intSignUp);
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        mFirebaseAuth.addAuthStateListener(mAuthStateListener);
    }

}





/*

String user_name, pass_word;
EditText username,
        password;
TextView signUpLink;
Button loginButton;
    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

       username = findViewById(R.id.username);
       password = findViewById(R.id.password);
       signUpLink = findViewById(R.id.textView10);

       loginButton = findViewById(R.id.loginButton);
       loginButton.setOnClickListener(new View.OnClickListener(){
           @Override
           public void onClick(View v) {
               user_name = username.getText().toString();
               pass_word = password.getText().toString();
               if(!user_name.isEmpty() && !pass_word.isEmpty())
               {
                   makeText(login.this, R.string.success_lable, LENGTH_LONG).show();
                   Intent i = new Intent ( login.this,MainActivity.class);
                   startActivity(i);
               }
               else {
                   makeText(login.this, R.string.error_label, LENGTH_SHORT).show();
               }
           }
       });


       signUpLink.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent i = new Intent(login.this,signup.class);
               startActivity(i);
           }
       });
}



 */