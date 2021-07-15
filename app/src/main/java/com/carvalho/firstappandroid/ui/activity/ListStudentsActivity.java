package com.carvalho.firstappandroid.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import com.carvalho.firstappandroid.R;
import com.carvalho.firstappandroid.dao.StudentDao;
import com.carvalho.firstappandroid.model.Student;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListStudentsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_students);

        setTitle("Lista de alunos");

        FloatingActionButton fab = findViewById(R.id.activity_main_fab_new_student);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ListStudentsActivity.this,
                        FormStudentActivity.class));
            }
        });
    }

    @Override
    protected void onResume() {
        StudentDao dao = new StudentDao();

        super.onResume();
        ListView listStudents = findViewById(R.id.activity_main_list_students);
        listStudents.setAdapter(new ArrayAdapter<>(
                this, android.R.layout.simple_list_item_1,dao.allStudents()
        ));
    }
}