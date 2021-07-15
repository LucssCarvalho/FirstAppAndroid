package com.carvalho.firstappandroid.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.carvalho.firstappandroid.R;
import com.carvalho.firstappandroid.dao.StudentDAO;
import com.carvalho.firstappandroid.model.Student;

public class FormStudentActivity extends AppCompatActivity {

    public static final String TITLE_APPBAR = "Novo aluno";
    private EditText inputName;
    private EditText inputPhone;
    private EditText inputEmail;
    final StudentDAO dao = new StudentDAO();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_student);

        setTitle(TITLE_APPBAR);
        initInputs();
        findViewById(R.id.activity_form_student_button_save);
        configureButtonSave();
    }

    private void configureButtonSave() {
        Button buttonSave = findViewById(R.id.activity_form_student_button_save);
        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Student student = createStudent();
                save(student);
            }
        });
    }

    private void initInputs() {
        inputName = findViewById(R.id.activity_form_student_name);
        inputPhone = findViewById(R.id.activity_form_student_phone);
        inputEmail = findViewById(R.id.activity_form_student_mail);
    }

    private void save(Student student) {
        dao.save(student);

        finish();
    }

    @NonNull
    private Student createStudent() {
        String name = inputName.getText().toString();
        String phone = inputPhone.getText().toString();
        String email = inputEmail.getText().toString();
        Student student = new Student(name, phone, email);
        return student;
    }
}