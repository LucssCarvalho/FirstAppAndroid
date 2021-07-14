package com.carvalho.firstappandroid.ui.activity;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.carvalho.firstappandroid.R;
import com.carvalho.firstappandroid.model.Student;

public class FormStudentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_student);
        final EditText inputName = findViewById(R.id.activity_form_student_name);
        final EditText inputPhone = findViewById(R.id.activity_form_student_phone);
        final EditText inputEmail = findViewById(R.id.activity_form_student_mail);

        findViewById(R.id.activity_form_student_button_save);

        Button buttonSave = findViewById(R.id.activity_form_student_button_save);

        buttonSave.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String name = inputName.getText().toString();
                String phone = inputPhone.getText().toString();
                String email = inputEmail.getText().toString();

                Student student = new Student(name, phone,email);
                Toast.makeText(FormStudentActivity.this,
                        student.getName() + "-"
                        + student.getPhone() + "-"
                        + student.getEmail(), Toast.LENGTH_LONG).show();
                
            }
        });

    }
}