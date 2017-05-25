package com.example.a15039840.taskmanager;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView lv;
    ArrayAdapter aa;
    ArrayList<Task> alTask;
    Button btnAdd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv = (ListView)findViewById(R.id.lv);
        btnAdd = (Button)findViewById(R.id.btnAdd);
        DBHelper db = new DBHelper(MainActivity.this);
        alTask = db.getAllTasks();

        aa = new ArrayAdapter(this, android.R.layout.simple_list_item_1, alTask);
        lv.setAdapter(aa);
        aa.notifyDataSetChanged();
        db.close();

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, AddActivity.class);
                startActivityForResult(i, 9);
            }
        });



    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK && requestCode == 9 ) {
            DBHelper db = new DBHelper(MainActivity.this);
            alTask = db.getAllTasks();
            aa = new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1, alTask);
            lv.setAdapter(aa);
        }
    }
}
