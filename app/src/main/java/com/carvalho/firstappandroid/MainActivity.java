package com.carvalho.firstappandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        List<String> students = new ArrayList<>(
             Arrays.asList("Alex","Pedro","Maria","Lucas"));
        ListView listStudents = findViewById(R.id.list_students);
        listStudents.setAdapter(new ArrayAdapter<>(
                this, android.R.layout.simple_list_item_1,students
        ));
    }
}