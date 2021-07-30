package com.carvalho.firstappandroid.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.carvalho.firstappandroid.R;
import com.carvalho.firstappandroid.dao.StudentDAO;
import com.carvalho.firstappandroid.model.Student;

import static com.carvalho.firstappandroid.ui.activity.ConstantActivities.KEY_STUDENT;

public class FormStudentActivity extends AppCompatActivity {

    private static final String TITLE_APPBAR_NEW_STUDENT = "Novo aluno";
    private static final String TITLE_APPBAR_EDIT_STUDENT = "Edita aluno";
    private EditText inputName;
    private EditText inputPhone;
    private EditText inputEmail;
    final StudentDAO dao = new StudentDAO();
    private Student student;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_student);
        initInputs();
        findViewById(R.id.activity_form_student_button_save);
        configureButtonSave();
        getStudent();
    }

    private void getStudent() {
        final Intent data = getIntent();
        if (data.hasExtra(KEY_STUDENT)) {
            student = (Student) data.getSerializableExtra(KEY_STUDENT);
            fillInput();
            setTitle(TITLE_APPBAR_EDIT_STUDENT);
        } else {
            setTitle(TITLE_APPBAR_NEW_STUDENT);
        }
    }

    private void fillInput() {
        inputName.setText(student.getName());
        inputPhone.setText(student.getPhone());
        inputEmail.setText(student.getEmail());
    }

    private void configureButtonSave() {
        Button buttonSave = findViewById(R.id.activity_form_student_button_save);
        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finishForm();
            }
        });
    }

    private void finishForm() {
        fillStudent();
        if (student.hasValidId()) {
            dao.edit(student);
        } else {
            dao.save(student);
        }
        finish();
    }

    private void initInputs() {
        inputName = findViewById(R.id.activity_form_student_name);
        inputPhone = findViewById(R.id.activity_form_student_phone);
        inputEmail = findViewById(R.id.activity_form_student_mail);
    }

    private void fillStudent() {
        String name = inputName.getText().toString();
        String phone = inputPhone.getText().toString();
        String email = inputEmail.getText().toString();
        student.setName(name);
        student.setPhone(phone);
        student.setEmail(email);
    }
}