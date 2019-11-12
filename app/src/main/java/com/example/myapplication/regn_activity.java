package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;

import java.util.regex.Pattern;


public class regn_activity extends AppCompatActivity {
    FirebaseAuth firebaseAuth;
    Button signup;
    EditText remail,rpass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regn);

        TextView signIn_text = findViewById(R.id.signIn_text);
        firebaseAuth= FirebaseAuth.getInstance();
        remail=findViewById(R.id.remail);
        rpass=findViewById(R.id.rpass);
        signup=findViewById(R.id.signup);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email=remail.getText().toString();
                String pass=rpass.getText().toString();
                if (isValidEmailId(email)==true&&pass.length()>6)
                {
                    firebaseAuth.createUserWithEmailAndPassword(email,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful())
                            {
                                Toast.makeText(regn_activity.this, "Signup sucess", Toast.LENGTH_SHORT).show();
                                Intent i=new Intent(regn_activity.this,MainActivity.class);
                                startActivity(i);
                            }
                            else
                            {
                                if (task.getException() instanceof FirebaseAuthUserCollisionException)
                                {
                                    Toast.makeText(regn_activity.this, "user already exists", Toast.LENGTH_SHORT).show();
                                }
                                else
                                {

                                    Toast.makeText(regn_activity.this, "error", Toast.LENGTH_SHORT).show();
                                }
                            }
                        }
                    });
                }
                else
                {
                    Toast.makeText(regn_activity.this, "Provide valid email and pass", Toast.LENGTH_SHORT).show();
                }
            }
        });
        signIn_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(regn_activity.this, MainActivity.class));
                finish();
            }
        });


    }
    private boolean isValidEmailId(String email){

        return Pattern.compile("^(([\\w-]+\\.)+[\\w-]+|([a-zA-Z]{1}|[\\w-]{2,}))@"
                + "((([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
                + "[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\."
                + "([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
                + "[0-9]{1,2}|25[0-5]|2[0-4][0-9])){1}|"
                + "([a-zA-Z]+[\\w-]+\\.)+[a-zA-Z]{2,4})$").matcher(email).matches();
    }
}
