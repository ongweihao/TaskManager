package com.example.a15039840.taskmanager;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Calendar;

public class AddActivity extends AppCompatActivity {

    Button btnAdd, btnCancel;
    EditText etName, etDescription;
    EditText etReminder;
    Intent i;
    int reqCode = 1234;
    DBHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        btnAdd = (Button)findViewById(R.id.buttonAdd);
        btnCancel = (Button)findViewById(R.id.buttonCancel);
        etName = (EditText)findViewById(R.id.editTextName);
        etDescription = (EditText)findViewById(R.id.editTextDescription);
        etReminder=(EditText)findViewById(R.id.editTextRemind);
        db = new DBHelper(AddActivity.this);

        i=getIntent();

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Create the DBHelper object, passing in the
                // activity's Context
                DBHelper db = new DBHelper(AddActivity.this);
                String name  = etName.getText().toString();
                String description = etDescription.getText().toString();
                int remind = Integer.parseInt(etReminder.getText().toString());
                // Insert a task
                db.insertTask(name,description);
                Toast.makeText(AddActivity.this, "Added Task", Toast.LENGTH_LONG).show();

                db.close();
                setResult(RESULT_OK, i);
                Calendar cal = Calendar.getInstance();
                cal.add(Calendar.SECOND, remind);

                Intent intent = new Intent(AddActivity.this, TaskBroadcastReceiver.class);
                intent.putExtra("name", name);
                PendingIntent pendingIntent = PendingIntent.getBroadcast(AddActivity.this, reqCode, intent, PendingIntent.FLAG_CANCEL_CURRENT);
                AlarmManager am = (AlarmManager)getSystemService(Activity.ALARM_SERVICE);
                am.set(AlarmManager.RTC_WAKEUP, cal.getTimeInMillis(), pendingIntent);
                finish();
            }
        });
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


    }
}
