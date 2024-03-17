package com.rexportfolioapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button btn = findViewById(R.id.btnSave);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onSaveClick();
            }
        });
    }

    private void onSaveClick() {
        //Get Inputs
        EditText etName = findViewById(R.id.etName);
        String name = etName.getText().toString();

        EditText etPhone = findViewById(R.id.etPhone);
        String phoneNum = etPhone.getText().toString();

        EditText etEmail = findViewById(R.id.etEmail);
        String email = etEmail.getText().toString();

        EditText etSkills = findViewById(R.id.etSkills);
        String skills = etSkills.getText().toString();

        EditText etWebsite = findViewById(R.id.etWebsite);
        String website = etWebsite.getText().toString();

        EditText etAbout = findViewById(R.id.etAbout);
        String about = etAbout.getText().toString();

        //Validate Inputs
        if (name.length() < 2) {
            Toast.makeText(this, "Name must be longer.", Toast.LENGTH_SHORT).show();
        }

        if (about.length() < 20) {
            Toast.makeText(this, "About must be at least 20 characters.", Toast.LENGTH_SHORT).show();
        }

        //Show Summary
        TextView tvAboutSummary = findViewById(R.id.tvAboutSummary);
        tvAboutSummary.setText("Hello everyone! I am " + name + ". My skills are " + skills + "." + about + ".");

        TextView tvContact = findViewById(R.id.tvContact);
        tvContact.setText("You can check my website at " + website + ". You can also contact me through email: " + email + " or through phone: " + phoneNum + ".");

        Toast.makeText(this, "Information Saved", Toast.LENGTH_SHORT).show();
    }
}