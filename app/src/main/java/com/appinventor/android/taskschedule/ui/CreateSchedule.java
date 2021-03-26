package com.appinventor.android.taskschedule.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;

import com.appinventor.android.taskschedule.R;

public class CreateSchedule extends AppCompatActivity {

    private EditText editTextTaskName;
    private EditText editTextDetails;
    private ImageView imageViewDate;
    private ImageView imageViewTime;
    private Spinner spinnerNotificationMethod;
    private Spinner spinnerNotificationTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_schedule);

        editTextTaskName = findViewById(R.id.task_name);
        editTextDetails = findViewById(R.id.details);
        imageViewDate = findViewById(R.id.date);
        imageViewTime = findViewById(R.id.time);
        spinnerNotificationMethod = findViewById(R.id.notification_method);
        spinnerNotificationTime = findViewById(R.id.notification_time);

        getSupportActionBar().setHomeAsUpIndicator(R.drawable.arrow_back);
        setTitle("Add Schedule");
    }
}