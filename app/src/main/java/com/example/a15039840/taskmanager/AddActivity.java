package com.example.a15039840.taskmanager;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddActivity extends AppCompatActivity {

    Button btnAdd, btnCancel;
    EditText etName, etDescription;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        btnAdd = (Button)findViewById(R.id.buttonAdd);
        btnCancel = (Button)findViewById(R.id.buttonCancel);
        etName = (EditText)findViewById(R.id.editTextName);
        etDescription = (EditText)findViewById(R.id.editTextDescription);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Create the DBHelper object, passing in the
                // activity's Context
                DBHelper db = new DBHelper(AddActivity.this);
                String name  = etName.getText().toString();
                String description = etDescription.getText().toString();
                // Insert a task
                db.insertTask(name,description);
                Toast.makeText(AddActivity.this, "Added Task", Toast.LENGTH_LONG).show();
                db.close();
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
