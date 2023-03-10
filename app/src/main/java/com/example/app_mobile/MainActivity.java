package com.example.app_mobile;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button conn = findViewById(R.id.btnconn);
        TextView user = findViewById(R.id.username);
        TextView pass = findViewById(R.id.MDP);



        FirebaseAuth mAuth;

        mAuth = FirebaseAuth.getInstance();

        conn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = user.getText().toString();
                String password = pass.getText().toString();

                mAuth.signInWithEmailAndPassword(email, password)
                        .addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    Intent intent = new Intent(MainActivity.this, DashBord.class);
                                    startActivity(intent);
                                } else {
                                    Toast.makeText(MainActivity.this, "Authentication failed.", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
            }
        });
    }
}

