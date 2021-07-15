package com.carvalho.firstappandroid.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.carvalho.firstappandroid.R;
import com.carvalho.firstappandroid.dao.StudentDAO;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class ListStudentsActivity extends AppCompatActivity {

    public static final String TITLE_APPBAR = "Lista de alunos";
    private StudentDAO dao = new StudentDAO();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_students);

        setTitle(TITLE_APPBAR);

        configureFabNewStudent();
    }

    private void configureFabNewStudent() {
        FloatingActionButton fab = findViewById(R.id.activity_main_fab_new_student);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFormStudentActivity();
            }
        });
    }

    private void openFormStudentActivity() {
        startActivity(new Intent(this,
                FormStudentActivity.class));
    }

    @Override
    protected void onResume() {

        super.onResume();
        configList();
    }

    private void configList() {
        ListView listStudents = findViewById(R.id.activity_main_list_students);
        listStudents.setAdapter(new ArrayAdapter<>(
                this, android.R.layout.simple_list_item_1,dao.allStudents()
        ));
    }
}