package com.example.a15039840.taskmanager;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView lv;
    ArrayAdapter aa;
    ArrayList<Task> tasks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv=(ListView)findViewById(R.id.lv);
        DBHelper db = new DBHelper(MainActivity.this);
        tasks=db.getAllTasks();

        aa = new ArrayAdapter(this, android.R.layout.simple_list_item_1, tasks);
        lv.setAdapter(aa);
        aa.notifyDataSetChanged();
        db.close();

    }
}
