package com.carvalho.firstappandroid.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import com.carvalho.firstappandroid.R;
import com.carvalho.firstappandroid.dao.StudentDAO;
import com.carvalho.firstappandroid.model.Student;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

import static com.carvalho.firstappandroid.ui.activity.ConstantActivities.KEY_STUDENT;

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
                openFormForCreateStudent();
            }
        });
    }

    private void openFormForCreateStudent() {
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
        final List<Student> students = dao.allStudents();
        configAdapter(listStudents);
        configListernForAnItem(listStudents);
    }

    private void configListernForAnItem(ListView listStudents) {
        listStudents.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Student studentSelected = (Student) adapterView.getItemAtPosition(position);
                openFormForEditStudent(studentSelected);
            }
        });
    }

    private void openFormForEditStudent(Student studentSelected) {
        Intent navigateForm = new Intent(ListStudentsActivity.this, FormStudentActivity.class);
        navigateForm.putExtra(KEY_STUDENT, studentSelected);
        startActivity(navigateForm);
    }

    private void configAdapter(ListView listStudents) {
        listStudents.setAdapter(new ArrayAdapter<>(
                this, android.R.layout.simple_list_item_1, dao.allStudents()));
    }
}